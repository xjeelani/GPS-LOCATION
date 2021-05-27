package com.xjilani.xjgps;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class JLocationService implements LocationListener {

    long CURTIME=0;
    long PREVTIME=0;
    TextView latView;TextView lonView;TextView accuracyView;
    void viewLocation()
    {
        if(latView!=null && lonView!=null && accuracyView!=null)
        {
            latView.setText(""+JConfig.LATITUDE);
            lonView.setText(""+JConfig.LONGITUDE);
            accuracyView.setText(""+JConfig.ACCURACY);
        }
    }
    public JLocationService(Activity activity, TextView latView, TextView lonView, TextView accuracyView) {
        JConfig.ACCURACY_NEXT=-1;
        this.latView=latView;
        this.lonView=lonView;
        this.accuracyView=accuracyView;
        LocationManager locationManager = (LocationManager) JConfig.CONTEXT.getSystemService(JConfig.CONTEXT.LOCATION_SERVICE);
        LocationListener locationListener = this;
        if (ActivityCompat.checkSelfPermission( JConfig.CONTEXT, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission( JConfig.CONTEXT, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            JConfig.GPS_GRANTED=false;
            Toast.makeText(JConfig.CONTEXT,"NO GPS PERMISSION GRANTED !",Toast.LENGTH_SHORT).show();
            return;
        }
        Location location=locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if ( !locationManager.isProviderEnabled( LocationManager.GPS_PROVIDER ) ) {
            try{
                activity.startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
            }catch(Exception ee){}
        }
        if(location!=null)
        {
            JConfig.LATITUDE=location.getLatitude();
            JConfig.LONGITUDE=location.getLongitude();
            JConfig.ACCURACY=location.getAccuracy();

            JConfig.LATITUDE_NEXT=location.getLatitude();
            JConfig.LONGITUDE_NEXT=location.getLongitude();
            JConfig.ACCURACY_NEXT=location.getAccuracy();
        }
        viewLocation();
        CURTIME=System.currentTimeMillis();
        PREVTIME=System.currentTimeMillis();
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5, locationListener);
    }
    @Override
    public void onLocationChanged(@NonNull Location location) {
        CURTIME=System.currentTimeMillis();
        if(location!=null)
        {
            JConfig.LATITUDE_NEXT=location.getLatitude();
            JConfig.LONGITUDE_NEXT=location.getLongitude();
            JConfig.ACCURACY_NEXT=location.getAccuracy();
            if(JConfig.ACCURACY>=JConfig.ACCURACY_NEXT)
            {
                JConfig.LATITUDE=JConfig.LATITUDE_NEXT;
                JConfig.LONGITUDE=JConfig.LONGITUDE_NEXT;
                JConfig.ACCURACY=JConfig.ACCURACY_NEXT;

            }
            else if((CURTIME-PREVTIME)>=JConfig.REFRESHTIME)
            {  PREVTIME=CURTIME;
                JConfig.LATITUDE=JConfig.LATITUDE_NEXT;
                JConfig.LONGITUDE=JConfig.LONGITUDE_NEXT;
                JConfig.ACCURACY=JConfig.ACCURACY_NEXT;

            }

        }
        viewLocation();
    }


}

