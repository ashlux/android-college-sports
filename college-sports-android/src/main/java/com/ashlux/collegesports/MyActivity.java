package com.ashlux.collegesports;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.ashlux.collegesports.news.NewsRetriever;
import com.ashlux.collegesports.news.NewsRetrieverImpl;
import com.ashlux.repackaged.com.sun.syndication.feed.synd.SyndEntry;
import com.ashlux.repackaged.com.sun.syndication.feed.synd.SyndFeed;

import java.util.List;

public class MyActivity
    extends Activity
{
    private static final String TAG = "MyActivity";

    @Override
    public void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.main );

        NewsRetriever newsRetriever = new NewsRetrieverImpl();
        SyndFeed syndFeed = newsRetriever.getMostRecentNews();
        Log.v( TAG, syndFeed.getTitle() );
        List<SyndEntry> entries = syndFeed.getEntries();
        for ( SyndEntry entry : entries )
        {
            Log.v( TAG, "--------------------------------------------" );
            Log.v( TAG, "--------------------------------------------" );
            Log.v( TAG, "--------------------------------------------" );
            Log.v( TAG,   "Entry : " + entry.getTitle() );
            Log.v( TAG, "    URI : " + entry.getUri() );
            Log.v( TAG, "Content :" + entry.getDescription().toString() );
        }

//        // Example client
//        ClientResource cr = new ClientResource( "http://ashlux.no-ip.org:9999/rest/schedules" );
////                  "http://sportsscoresfeed.appspot.com/rest/schedules");
//        ScheduleDao scheduleDao = cr.wrap( ScheduleDao.class );
//        Game[] games = scheduleDao.getSchedule();
//        System.out.println( games.length );
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
        switch ( item.getItemId() )
        {
            case R.id.quit:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected( item );
        }
    }
}
