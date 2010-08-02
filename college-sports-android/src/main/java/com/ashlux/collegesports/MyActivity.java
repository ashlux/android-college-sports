package com.ashlux.collegesports;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ListView;

public class MyActivity
    extends Activity
{
    private static final String TAG = "MyActivity";

    @Override
    public void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        requestWindowFeature( Window.FEATURE_NO_TITLE );
        setContentView( createList( this ) );


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

    private View createList( Activity activity )
    {
        LinearLayout mainPanel = new LinearLayout( activity );
        ListView listView = new ListView( activity );
        final FeedListAdapter feedListAdapter = new FeedListAdapter( activity );
        listView.setAdapter( feedListAdapter );
        mainPanel.addView( listView );
        return mainPanel;
    }
}
