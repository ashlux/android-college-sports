package com.ashlux.sportsscores.services;

import com.ashlux.sportsscores.domain.Game;
import org.restlet.resource.ClientResource;
import org.testng.annotations.Test;

public class ScheduleDaoImplTest
{
    @Test
    public void test()
    {
        // Example client
        ClientResource cr = new ClientResource(
//                "http://localhost:8080/rest/schedules");
                  "http://sportsscoresfeed.appspot.com/rest/schedules");
         ScheduleDao scheduleDao = cr.wrap( ScheduleDao.class );
        System.out.println(scheduleDao);

        Game[] games = scheduleDao.getSchedule();
        System.out.println(games.length);
    }
}
