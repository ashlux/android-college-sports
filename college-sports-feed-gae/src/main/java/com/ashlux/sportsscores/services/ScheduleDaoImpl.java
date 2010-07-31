package com.ashlux.sportsscores.services;

import com.ashlux.sportsscores.domain.Game;
import org.apache.commons.lang.StringUtils;
import org.htmlparser.NodeFilter;
import org.htmlparser.beans.FilterBean;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.util.NodeList;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

public class ScheduleDaoImpl
    extends ServerResource
    implements ScheduleDao
{
    public Game[] getSchedule()
    {
        System.out.println("PING!");

        List<Game> games = new LinkedList<Game>();

        final String url = "http://www.okstate.com/sports/m-basebl/sched/okst-m-basebl-sched.html";

        final HasAttributeFilter filter1 = new HasAttributeFilter();
        filter1.setAttributeName( "class" );
        filter1.setAttributeValue( "row-text" );

        final FilterBean filterBean = new FilterBean();
        filterBean.setFilters( new NodeFilter[]{ filter1 } );
        filterBean.setURL( url );

        final NodeList nodeList = filterBean.getNodes();
        for ( int i = 0; i < nodeList.size(); i += 4 )
        {
            final String date = nodeList.elementAt( i ).toPlainTextString(); // &nbsp; when double header
            final String opponent = nodeList.elementAt( i + 1 ).toPlainTextString(); // Polluted with #, *, and <img>
            final String location = nodeList.elementAt( i + 2 ).toPlainTextString();
            final String timeOrResult = nodeList.elementAt( i + 3 ).toPlainTextString(); // Can be either

            Game game = new Game();
            game.setDate( date );
            game.setLocation( location );
            game.setHomeTeam( isHomeTeam( opponent ) ? "Oklahoma State" : formatOpponent( opponent ) );
            game.setAwayTeam( isHomeTeam( opponent ) ? formatOpponent( opponent ) : "Oklahoma State" );
            game.setScore( formatScore( timeOrResult ) );
            game.setWinner( determineWinner( opponent, timeOrResult ) );
            games.add( game );
        }

        return games.toArray( new Game[games.size()] );
    }

    private String formatScore( String timeOrResult )
    {
        // "W, 9-3"
        // "L, 3-5"
        if ( StringUtils.startsWith( timeOrResult, "W, " ) || StringUtils.startsWith( timeOrResult, "L, " ) )
        {
            return StringUtils.substringAfter( timeOrResult, " " );
        }

        // "TBA"
        // "6:00 p.m. CT"
        return "";
    }

    private String determineWinner( String opponent, String timeOrResult )
    {
        return StringUtils.contains( timeOrResult, "W," ) ? "Oklahoma State" : formatOpponent( opponent );
    }

    private String formatOpponent( final String opponent )
    {
        // Opponent name sometimes is between "at OPPONENT NAME <img src=...>" or between "vs. OPPONENT NAME <img src=...>"
        String formattedOpponent = StringUtils.substringBetween( opponent, " ", "<img" );
        if ( StringUtils.isNotBlank( formattedOpponent ) )
        {
            return formattedOpponent;
        }

        // Opponent name is followed after "at" or "vs." and no image oppponent name
        formattedOpponent = StringUtils.substringAfter( opponent, " " );
        return formattedOpponent;
    }

    private boolean isHomeTeam( String opponent )
    {
        return StringUtils.startsWith( opponent, "vs." );
    }
}