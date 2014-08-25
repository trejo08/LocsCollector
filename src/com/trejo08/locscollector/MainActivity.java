package com.trejo08.locscollector;

import android.app.Activity;
import android.os.Bundle;

// Packages for collect GPS coords
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.widget.Toast;

// Package for make to vibrate device
import android.os.Vibrator;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // initializing LocationManager
        LocationManager location_manager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        LocationListener location_listener = new CustomLocationListener();
        
        
        location_manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, location_listener);
    }
    
    //Class for make a new coordinates    
    public class CustomLocationListener implements LocationListener{
    	// Public method for showing actual coordinates
    	public void onLocationChanged(Location loc){
    		loc.getLatitude();
    		loc.getLongitude();
    		String coordenadas = "Mis coordenadas son: Latitud = " + loc.getLatitude() + ", Longitud = " + loc.getLongitude();
    		Toast.makeText(getApplicationContext(), coordenadas, Toast.LENGTH_LONG).show();
    	}
    	
    	//Public
    	public void onProviderDisabled(String provider){
    		Toast.makeText(getApplicationContext(),"GPS Desactivado", Toast.LENGTH_SHORT).show();
    	}
    	
    	public void onProviderEnabled(String provider){
    		Toast.makeText( getApplicationContext(),"GPS Activo",Toast.LENGTH_SHORT).show();
    	}
    	
    	
    	public void onStatusChanged(String provider, int status, Bundle extras){}
    }
    
    /*public class CustomStartVibration implements Vibrator {
    	public void startVibrate(int loops){
    		Vibrator v = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
    		v.vibrate(500);
    	}
    	public void onStatusChanged(String provider, int status, Bundle extras){}
    	
    }*/
}
