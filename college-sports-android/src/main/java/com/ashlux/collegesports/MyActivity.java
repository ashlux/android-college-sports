package com.ashlux.collegesports;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;
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
        ClientResource cr = new ClientResource( "http://ashlux.no-ip.org:9999/rest/schedules" );
//                  "http://sportsscoresfeed.appspot.com/rest/schedules");
        ScheduleDao scheduleDao = cr.wrap( ScheduleDao.class );
        Game[] games = scheduleDao.getSchedule();
        System.out.println( games.length );
    }

    @Override
    public boolean onCreateOptionsMenu( Menu menu )
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate( R.menu.game_menu, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item )
    {
        switch(item.getItemId())
        {
            case R.id.quit:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected( item );
        }
    }
}
