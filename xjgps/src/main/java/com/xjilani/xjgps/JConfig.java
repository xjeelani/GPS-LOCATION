package com.xjilani.xjgps;

import android.content.Context;

public class JConfig {
    public static Context CONTEXT=null;

    public final  static int REQUEST_GPS=701;
    public static boolean GPS_GRANTED=false;
    public static double LATITUDE=0.0;
    public static double LONGITUDE=0.0;
    public static float ACCURACY=500;

    public static double LATITUDE_NEXT=0.0;
    public static double LONGITUDE_NEXT=0.0;
    public static float ACCURACY_NEXT=-1;
    public static long REFRESHTIME=60*1000;
}