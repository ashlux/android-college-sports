package com.ashlux.collegesports.news;

import com.ashlux.repackaged.com.sun.syndication.feed.synd.SyndFeed;

public interface NewsRetriever
{
    SyndFeed getMostRecentNews();
}
