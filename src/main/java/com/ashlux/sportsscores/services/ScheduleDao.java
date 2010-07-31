package com.ashlux.sportsscores.services;

import com.ashlux.sportsscores.domain.Game;
import org.restlet.resource.Get;

public interface ScheduleDao
{
    @Get
    Game[] getSchedule();
}
