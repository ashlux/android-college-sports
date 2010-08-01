package com.ashlux.collegesports.exceptions;

public class CollegeSportsRuntimeException
    extends RuntimeException
{
    public CollegeSportsRuntimeException()
    {
    }

    public CollegeSportsRuntimeException( String message )
    {
        super( message );
    }

    public CollegeSportsRuntimeException( String message, Throwable cause )
    {
        super( message, cause );
    }

    public CollegeSportsRuntimeException( Throwable cause )
    {
        super( cause );
    }
}
