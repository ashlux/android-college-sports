package com.ashlux.collegesports;

import android.app.Activity;
import android.os.Bundle;
import com.ashlux.sportsscores.domain.Game;
import com.ashlux.sportsscores.services.ScheduleDao;
import org.restlet.resource.ClientResource;

public class MyActivity
    extends Activity
{
    @Override
    public void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.main );

        // Example client
        System.out.println(1);
        ClientResource cr = new ClientResource(
//                "http://localhost:8080/rest/schedules");
                  "http://sportsscoresfeed.appspot.com/rest/schedules");
        System.out.println(2);
         ScheduleDao scheduleDao = cr.wrap( ScheduleDao.class );
        System.out.println(3);
        System.out.println(scheduleDao);
        System.out.println(4);
        Game[] games = scheduleDao.getSchedule();
        System.out.println(games.length);
    }
}
