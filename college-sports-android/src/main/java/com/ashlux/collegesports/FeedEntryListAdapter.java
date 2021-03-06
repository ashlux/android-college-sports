package com.ashlux.collegesports;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.ashlux.collegesports.news.NewsRetriever;
import com.ashlux.collegesports.news.NewsRetrieverImpl;
import com.google.code.rome.android.repackaged.com.sun.syndication.feed.synd.SyndEntry;
import com.google.code.rome.android.repackaged.com.sun.syndication.feed.synd.SyndFeed;

import java.text.SimpleDateFormat;

public class FeedEntryListAdapter
    extends BaseAdapter
{
    private SyndFeed feed;

    private Activity context;

    public FeedEntryListAdapter( Activity context )
    {
        this.context = context;

        NewsRetriever newsRetriever = new NewsRetrieverImpl();
        feed = newsRetriever.getMostRecentNews();
    }

    public int getCount()
    {
        return feed.getEntries().size();
    }

    public SyndEntry getItem( int index )
    {
        return (SyndEntry) feed.getEntries().get( index );
    }

    public long getItemId( int index )
    {
        return index;
    }

    public View getView( int index, View cellRenderer, ViewGroup viewGroup )
    {
        final View view = context.getLayoutInflater().inflate( R.layout.feed_entry_row, null );
        bindDataToView( view, (SyndEntry) feed.getEntries().get( index ) );
        return view;
    }

    private void bindDataToView( View view, SyndEntry entry )
    {
        final TextView titleView = (TextView) view.findViewById( R.id.title );
        titleView.setText( entry.getTitle() );
        final TextView dateView = (TextView) view.findViewById( R.id.date );
        dateView.setText( formatDate( entry ) );
        final TextView summaryView = (TextView) view.findViewById( R.id.summary );
        summaryView.setText( entry.getDescription().getValue() );
    }

    private String formatDate( SyndEntry entry )
    {
        // format: Jul 29 2010, 4:30 PM 
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "MMM d yyyy, hh:mm a" );
        return simpleDateFormat.format( entry.getPublishedDate() );
    }


}
