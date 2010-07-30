package com.ashlux.sportsscores;

import org.htmlparser.NodeFilter;
import org.htmlparser.beans.FilterBean;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.util.NodeList;

import javax.jws.WebService;
import javax.ws.rs.Path;

@Path( "schedules" )
@WebService( endpointInterface = "com.ashlux.sportsscores.ParserSpike" )
public class ParserSpikeImpl
    implements ParserSpike
{

    public String getSchedule()
    {
        String schedule = "";

        final String url = "http://www.okstate.com/sports/m-basebl/sched/okst-m-basebl-sched.html";

        // <td class="row-text">11/14/09</td>
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
            schedule += date;
            schedule += opponent;
            schedule += location;
            schedule += timeOrResult;
            schedule += "<BR>";
        }

        return schedule;
    }
}