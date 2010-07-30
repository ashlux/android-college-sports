package com.ashlux.sportsscores;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@WebService
public interface ParserSpike
{
    @GET
    @Path( "schedule" )
    String getSchedule();
}
