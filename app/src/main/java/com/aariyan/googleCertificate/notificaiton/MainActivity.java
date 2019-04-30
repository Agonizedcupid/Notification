package com.aariyan.googleCertificate.notificaiton;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    //creating notification Channel :
    private void createNotifcationChannerl() {

        //creating notification channel but only work on API 26+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence channelName = getString(R.string.channelName);
            String description = getString(R.string.channelDescription);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            //NotificationChannel (Channel ID , Channel Name , Importance) :
            NotificationChannel notificationChannel = new NotificationChannel("Channel Id", channelName, importance);
            notificationChannel.setDescription(description);

            //Now register this Notification channel with the system :
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);
        }

    }
}
