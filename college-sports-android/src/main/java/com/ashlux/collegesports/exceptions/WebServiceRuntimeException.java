package com.ashlux.collegesports.exceptions;

public class WebServiceRuntimeException
    extends CollegeSportsRuntimeException
{
    public WebServiceRuntimeException()
    {
    }

    public WebServiceRuntimeException( String message )
    {
        super( message );
    }

    public WebServiceRuntimeException( String message, Throwable cause )
    {
        super( message, cause );
    }

    public WebServiceRuntimeException( Throwable cause )
    {
        super( cause );
    }
}
