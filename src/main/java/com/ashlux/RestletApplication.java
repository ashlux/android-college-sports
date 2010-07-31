package com.ashlux;

import com.ashlux.sportsscores.services.ScheduleDaoImpl;
import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

public class RestletApplication
    extends Application
{
    @Override
    public Restlet createInboundRoot()
    {
        Router router = new Router( getContext() );
        router.attach( "/schedules", ScheduleDaoImpl.class );
        return router;
    }
}
