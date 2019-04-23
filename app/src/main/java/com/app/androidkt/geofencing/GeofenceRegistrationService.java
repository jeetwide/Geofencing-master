package com.app.androidkt.geofencing;

import android.app.IntentService;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;

import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingEvent;

import java.util.List;

public class GeofenceRegistrationService extends IntentService {

    private static final String TAG = "GeoIntentService";

    public GeofenceRegistrationService() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        GeofencingEvent geofencingEvent = GeofencingEvent.fromIntent(intent);
        if (geofencingEvent.hasError()) {
            Log.d(TAG, "GeofencingEvent error " + geofencingEvent.getErrorCode());
        } else {
            int transaction = geofencingEvent.getGeofenceTransition();
            List<Geofence> geofences = geofencingEvent.getTriggeringGeofences();
            Geofence geofence = geofences.get(0);
            if (transaction == Geofence.GEOFENCE_TRANSITION_ENTER && geofence.getRequestId().equals(Constants.GEOFENCE_ID_Titanium)) {
                Toast.makeText(this, "You are inside Monitored Area ", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "You are inside Monitored Area ");

                String CHANNEL_ID = Constants.GEOFENCE_ID_Titanium;
                NotificationCompat.Builder builder =
                        new NotificationCompat.Builder(this)
                                .setSmallIcon(R.drawable.ic_stat_schedule)
                                .setContentTitle("You entered Titanium City Center")
                                .setContentText("Please connect to the office. ");

                builder.setAutoCancel(true);

                NotificationManager mNotificationManager =
                        (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                mNotificationManager.notify(0, builder.build());


            } else {
                Toast.makeText(this, "You Have gone outside Monitored Area", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "You are outside outside Monitored Area");
            }
        }
    }
}
