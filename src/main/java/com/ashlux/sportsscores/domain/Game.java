package com.ashlux.sportsscores.domain;

import java.io.Serializable;

public class Game
    implements Serializable
{
    private static final long serialVersionUID = 1L;

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
}
