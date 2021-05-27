package com.xjilani.xjgps;

import android.content.Context;

public class JConfig {
    public static Context CONTEXT=null;

    final static int REQUEST_GPS=701;
    public static boolean GPS_GRANTED=false;
    static double LATITUDE=0.0;
    static double LONGITUDE=0.0;
    static float ACCURACY=500;

    static double LATITUDE_NEXT=0.0;
    static double LONGITUDE_NEXT=0.0;
    static float ACCURACY_NEXT=-1;
    static long REFRESHTIME=60*1000;
}