package com.app.androidkt.geofencing;

import com.google.android.gms.maps.model.LatLng;

import java.util.HashMap;

/**
 * Created by brijesh on 15/4/17.
 */

public class Constants {


    public static final String GEOFENCE_ID_STAN_UNI = "STAN_UNI";
    public static final String GEOFENCE_ID_Ahmedabad = "Ahmedabad Airport";
    public static final String GEOFENCE_ID_Hansol_Police= "Hansol Police Chowky";
    public static final String GEOFENCE_ID_Titanium= "Titanium City Center";
    public static final String GEOFENCE_ID_Sachin_Tower= "Sachin Tower";
    public static final float GEOFENCE_RADIUS_IN_METERS = 100;

    /**
     * Map for storing information about stanford university in the Stanford.
     */
    public static final HashMap<String, LatLng> AREA_LANDMARKS = new HashMap<String, LatLng>();

    static {
        // stanford university.
        AREA_LANDMARKS.put(GEOFENCE_ID_STAN_UNI, new LatLng(37.427476, -122.170262));


        //Ahmedabad
        AREA_LANDMARKS.put(GEOFENCE_ID_Ahmedabad, new LatLng(23.0734, 72.6266));

        //Hansol Police Chowki
        AREA_LANDMARKS.put(GEOFENCE_ID_Hansol_Police, new LatLng(23.083693, 72.620746));

        //Titanium City Center
        AREA_LANDMARKS.put(GEOFENCE_ID_Titanium, new LatLng(23.011963, 72.523276));
    }
}
