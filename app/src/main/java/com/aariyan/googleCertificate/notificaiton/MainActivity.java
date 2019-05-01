package com.aariyan.googleCertificate.notificaiton;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button notificationBtn;

    private final String CHANNEL_ID = "Simple Notification";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //View Initializer :
        initView();

        //Notification Channel for Higher Android version >= O (Check weather the device version is higher or not):
        createNotificationChannel();

        //Notification Button Action :
        notificationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNotification();
            }
        });
    }


    //View initialization :
    private void initView() {
        notificationBtn = findViewById(R.id.notificationBtn);
    }


    //Show Notification :
    private void showNotification() {
        // Work if the device version lower than Android O :
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.fav)
                .setContentTitle("Notification Title")
                .setContentText("Simple Notification Text")
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("Simple Notification Text"))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(1, builder.build());
    }

    //creating notification Channel :
    private void createNotificationChannel() {

        //creating notification channel but only work on API 26+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence channelName = getString(R.string.channelName);
            String description = getString(R.string.channelDescription);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            //NotificationChannel (Channel ID , Channel Name , Importance) :
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, channelName, importance);
            notificationChannel.setDescription(description);

            //Now register this Notification channel with the system :
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);
        }

    }
}
