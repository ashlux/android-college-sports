package com.ashlux.sportsscores.domain;

import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement
public class Game
    implements Comparable<Game>
{
    private String date;

    private String homeTeam;

    private String awayTeam;

    private String location;

    private String winner;

    private String score;

    public String getDate()
    {
        return date;
    }

    public void setDate( String date )
    {
        this.date = date;
    }

    public String getHomeTeam()
    {
        return homeTeam;
    }

    public void setHomeTeam( String homeTeam )
    {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam()
    {
        return awayTeam;
    }

    public void setAwayTeam( String awayTeam )
    {
        this.awayTeam = awayTeam;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation( String location )
    {
        this.location = location;
    }

    public String getWinner()
    {
        return winner;
    }

    public void setWinner( String winner )
    {
        this.winner = winner;
    }

    public String getScore()
    {
        return score;
    }

    public void setScore( String score )
    {
        this.score = score;
    }

    @Override
    public boolean equals( Object o )
    {
        if ( this == o )
        {
            return true;
        }
        if ( o == null || getClass() != o.getClass() )
        {
            return false;
        }

        Game game = (Game) o;

        if ( awayTeam != null ? !awayTeam.equals( game.awayTeam ) : game.awayTeam != null )
        {
            return false;
        }
        if ( date != null ? !date.equals( game.date ) : game.date != null )
        {
            return false;
        }
        if ( homeTeam != null ? !homeTeam.equals( game.homeTeam ) : game.homeTeam != null )
        {
            return false;
        }
        if ( score != null ? !score.equals( game.score ) : game.score != null )
        {
            return false;
        }
        if ( location != null ? !location.equals( game.location ) : game.location != null )
        {
            return false;
        }
        if ( winner != null ? !winner.equals( game.winner ) : game.winner != null )
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = date != null ? date.hashCode() : 0;
        result = 31 * result + ( homeTeam != null ? homeTeam.hashCode() : 0 );
        result = 31 * result + ( awayTeam != null ? awayTeam.hashCode() : 0 );
        result = 31 * result + ( location != null ? location.hashCode() : 0 );
        result = 31 * result + ( winner != null ? winner.hashCode() : 0 );
        result = 31 * result + ( score != null ? score.hashCode() : 0 );
        return result;
    }


    @Override
    public int compareTo( Game o )
    {
        if ( this.equals( o ) )
        {
            return 0;
        }

        return this.getDate().compareTo( o.getDate() );
    }
}
