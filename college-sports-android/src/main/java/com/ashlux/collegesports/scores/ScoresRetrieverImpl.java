package com.ashlux.collegesports.scores;

import com.ashlux.sportsscores.domain.Game;
import com.ashlux.sportsscores.services.ScheduleDao;
import org.restlet.resource.ClientResource;

public class ScoresRetrieverImpl
    implements ScoresRetriever
{
    private static final String endpoint = "http://sportsscoresfeed.appspot.com/rest/schedules";

    public Game[] getMostRecentGames()
    {
        ClientResource cr = new ClientResource( endpoint );
        ScheduleDao scheduleDao = cr.wrap( ScheduleDao.class );
        return scheduleDao.getSchedule();
    }
}
