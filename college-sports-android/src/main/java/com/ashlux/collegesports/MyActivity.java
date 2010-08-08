package com.ashlux.collegesports;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import com.google.code.rome.android.repackaged.com.sun.syndication.feed.synd.SyndEntry;

public class MyActivity
    extends ListActivity
{
    @Override
    public void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setListAdapter( new FeedListAdapter( this ) );
    }

    @Override
    public boolean onCreateOptionsMenu( Menu menu )
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate( R.menu.menu, menu );
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

    @Override
    protected void onListItemClick( ListView l, View v, int position, long id )
    {
        SyndEntry entry = (SyndEntry) l.getItemAtPosition( position );

        new AlertDialog.Builder( this ).setTitle( "You clicked me!" ).setMessage( entry.getTitle() ).setCancelable(
            true ).create().show();
    }
}
