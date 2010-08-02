package com.ashlux.collegesports.news;

import com.ashlux.collegesports.exceptions.WebServiceRuntimeException;
import com.google.code.rome.android.repackaged.com.sun.syndication.feed.synd.SyndFeed;
import com.google.code.rome.android.repackaged.com.sun.syndication.fetcher.FeedFetcher;
import com.google.code.rome.android.repackaged.com.sun.syndication.fetcher.FetcherException;
import com.google.code.rome.android.repackaged.com.sun.syndication.fetcher.impl.HttpURLFeedFetcher;
import com.google.code.rome.android.repackaged.com.sun.syndication.io.FeedException;

import java.io.IOException;
import java.net.URL;

public class NewsRetrieverImpl
    implements NewsRetriever
{
    private static final String endpoint = "http://www.okstate.com/headline-rss.xml";

    public SyndFeed getMostRecentNews()
    {
        try
        {
            return retrieveFeed( endpoint );
        }
        catch ( Exception e )
        {
            throw new WebServiceRuntimeException( e );
        }
    }

    private SyndFeed retrieveFeed( String feedUrl )
        throws IOException, FeedException, FetcherException
    {
        FeedFetcher feedFetcher = new HttpURLFeedFetcher();
        return feedFetcher.retrieveFeed( new URL( feedUrl ) );
    }
}
