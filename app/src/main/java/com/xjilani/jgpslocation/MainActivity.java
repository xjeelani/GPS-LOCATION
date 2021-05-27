package com.xjilani.jgpslocation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static TextView textView=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //JConfig.CONTEXT=this.getApplicationContext();
        //askForGps(this);
        textView=findViewById(R.id.gpsText);

    }


   /* void askForGps(Activity activity)
    {
        if (ContextCompat.checkSelfPermission(JConfig.CONTEXT, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
        {
            JConfig.GPS_GRANTED=true;
            JLocationService locationService=new JLocationService(this);
        } else if (ActivityCompat.shouldShowRequestPermissionRationale(activity,Manifest.permission.ACCESS_FINE_LOCATION))
        {

        }
        else
        {
            ActivityCompat.requestPermissions(activity, new String[] { Manifest.permission.ACCESS_FINE_LOCATION},JConfig.REQUEST_GPS);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case JConfig.REQUEST_GPS :  if (grantResults.length > 0 &&   grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                JConfig.GPS_GRANTED=true;
                JLocationService locationService=new JLocationService(this);
                    } else JConfig.GPS_GRANTED=false;
                return;
        }
    } */

}