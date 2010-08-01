package com.ashlux.collegesports.scores;

import com.ashlux.sportsscores.domain.Game;

public interface ScoresRetriever
{
    public Game[] getMostRecentGames();
}