package com.ashlux.sportsscores.services;

import com.ashlux.sportsscores.domain.Game;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

public interface ScheduleDao
{
    @GET
    @Path( "/schedule" )
    Game[] getSchedule();
}
