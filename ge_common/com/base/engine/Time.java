package com.base.engine;

public class Time
{
    public static final long SECOND = 1000000000L;
    
    public static long getTime()
    {
        return System.nanoTime();
    }
}
