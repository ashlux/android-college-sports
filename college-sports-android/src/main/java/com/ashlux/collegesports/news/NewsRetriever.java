package com.ashlux.collegesports.news;

import com.google.code.rome.android.repackaged.com.sun.syndication.feed.synd.SyndFeed;

public interface NewsRetriever
{
    SyndFeed getMostRecentNews();
}
