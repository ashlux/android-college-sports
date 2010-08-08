package com.ashlux.collegesports;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import com.google.code.rome.android.repackaged.com.sun.syndication.feed.synd.SyndEntry;

public class FeedEntryListActivity
    extends ListActivity
{
    @Override
    public void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setListAdapter( new FeedEntryListAdapter( this ) );
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
        final SyndEntry entry = (SyndEntry) l.getItemAtPosition( position );
        final Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse( entry.getUri() ) );
        startActivity( intent );
    }
}
