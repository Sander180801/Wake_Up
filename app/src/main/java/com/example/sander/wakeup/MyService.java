package com.example.sander.wakeup;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.IBinder;


public class MyService extends Service {
    private int mId=1;
    public String EXTRA_ALARM_SIGNAL="ASignal";
    public String EXTRA_ALARM_TEXT_1="AText1";



    @Override
    public IBinder onBind(Intent arg0){
        return null;
    }
    public void onCreate(){
        super.onCreate();
    }
    @SuppressWarnings("static_access")


    @Override
    public int onStartCommand(Intent intent,int flags,int startId){
        super.onStartCommand(intent, flags, startId);



        Uri ringtone= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
        Notification.Builder mBuilder =
                new Notification.Builder(this)
                        .setSound(ringtone)
                        .setDefaults(Notification.DEFAULT_VIBRATE)
                        .setSmallIcon(R.drawable.ic_notification1)
                        .setContentTitle("ALARM!!ALARM!!")
                        .setContentText("Wakker worden!");


        Intent resultIntent = new Intent(this, MainActivity2.class);
        String text1="ALARM!!ALARM!!";
        resultIntent.putExtra(EXTRA_ALARM_SIGNAL, text1);
        resultIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity2.class);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(mId, mBuilder.build());







        return START_NOT_STICKY;



}}
