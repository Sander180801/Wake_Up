package com.example.sander.wakeup;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.provider.Settings;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.Voice;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity2 extends Activity {
public PendingIntent AlarmIntent1;
public PendingIntent AlarmIntent2;
public PendingIntent AlarmIntent3;
public PendingIntent AlarmIntent0;
public AlarmManager alarmManager;
    String EXTRA_ALARM_TEXT_1="Je hebt een alarm gezet voor het eerste uur";
    String EXTRA_ALARM_TEXT_2="Je hebt een alarm gezet voor het tweede uur";
    String EXTRA_ALARM_TEXT_3="Je hebt een alarm gezet voor het derde uur";
    String EXTRA_ALARM_SIGNAL;
    String MENU_ACTION;
    int  SET_ALARM_1;
    int SET_ALARM_2;
    int SET_ALARM_3;
    int id=1;
    int id2=2;
    int id3=3;
    int id0=0;
    int mId=1;
    int REQUEST_OK=1;
    int duration=1500;
    Intent intent1;
    Intent intent2;
    Intent intent3;
    Intent intent0;
    float transparentno=1;
  static String HOUR;
    static String MINUTE;
    static String TOMORROW;
    static String LABEL;
    String SHOW_TOAST;
    int minute;
    int hour;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);
        final TextView textView=(TextView)findViewById(R.id.textView2);
        final ImageButton DeleteButton = (ImageButton) findViewById(R.id.ButtonDelete);
        final ImageButton ButtonNew = (ImageButton) findViewById(R.id.ButtonNew);
        final ImageButton SilenceButton = (ImageButton)findViewById(R.id.silence_button);
        SilenceButton.setVisibility(View.INVISIBLE);
        DeleteButton.setVisibility(View.INVISIBLE);
        ButtonNew.setVisibility(View.VISIBLE);
        textView.setText(R.string.alarm_set);
        TextView timeView=(TextView)findViewById(R.id.TimeText);
        SimpleDateFormat format=new SimpleDateFormat("HH:mm");
        String time=format.format(new Date());
        timeView.setText(" " + time);



        if (getIntent().hasExtra(EXTRA_ALARM_TEXT_1)){
                textView.setText("Je hebt een alarm gezet voor het eerste uur");
                DeleteButton.setVisibility(View.VISIBLE);
                ButtonNew.setVisibility(View.INVISIBLE);
                ButtonNew.setAlpha(transparentno);
                alarmManager=(AlarmManager) getApplicationContext().getSystemService(Context.ALARM_SERVICE);
                intent1 = new Intent(getApplicationContext(),MyService.class);
                AlarmIntent1=PendingIntent.getService(getApplicationContext(), id, intent1, PendingIntent.FLAG_UPDATE_CURRENT);

                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                calendar.set(Calendar.HOUR_OF_DAY, 6);
                calendar.set(Calendar.MINUTE, 30);
                calendar.add(Calendar.DATE, 1);
                long AlarmTime=calendar.getTimeInMillis();
                alarmManager.set(AlarmManager.RTC_WAKEUP, AlarmTime, AlarmIntent1);

                Notification.Builder builder=new Notification.Builder(this)
                        .setSmallIcon(R.drawable.ic_notification1)
                        .setContentText("Je hebt een alarm gezet voor het eerste uur")
                        .setContentTitle("Alarm gezet");
                Intent intent=new Intent(this,MainActivity2.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                String text3="Je hebt een alarm gezet voor het eerste uur";
                intent.putExtra(EXTRA_ALARM_TEXT_1, text3);
                TaskStackBuilder builder1=TaskStackBuilder.create(getApplicationContext());
                builder1.addParentStack(MainActivity2.class);
                builder1.addNextIntent(intent);
                PendingIntent pendingIntent=builder1.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(pendingIntent);
                NotificationManager notificationManager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(mId,builder.build());

            }




        if (getIntent().hasExtra(EXTRA_ALARM_TEXT_2)){
                textView.setText("Je hebt een alarm gezet voor het tweede uur");
                DeleteButton.setVisibility(View.VISIBLE);
                ButtonNew.setVisibility(View.INVISIBLE);
                ButtonNew.setAlpha(transparentno);
                Context context2=getApplicationContext();
                alarmManager=(AlarmManager) getApplicationContext().getSystemService(Context.ALARM_SERVICE);
                intent2 = new Intent(getApplicationContext(),MyService2.class);
                AlarmIntent2=PendingIntent.getService(getApplicationContext(), id2, intent2, PendingIntent.FLAG_UPDATE_CURRENT);

                Calendar calendar2 = Calendar.getInstance();
                calendar2.setTimeInMillis(System.currentTimeMillis());
                calendar2.set(Calendar.HOUR_OF_DAY, 7);
                calendar2.set(Calendar.MINUTE, 15);
                calendar2.add(Calendar.DATE, 1);
                long AlarmTime2=calendar2.getTimeInMillis();
                alarmManager.set(AlarmManager.RTC_WAKEUP, AlarmTime2, AlarmIntent2);

                Notification.Builder builder=new Notification.Builder(this)
                        .setSmallIcon(R.drawable.ic_notification1)
                        .setContentText("Je hebt een alarm gezet voor het tweede uur")
                        .setContentTitle("Alarm gezet");
                Intent intent=new Intent(this,MainActivity2.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                String text3="Je hebt een alarm gezet voor het tweede uur";
                intent.putExtra(EXTRA_ALARM_TEXT_2, text3);
                TaskStackBuilder builder1=TaskStackBuilder.create(getApplicationContext());
                builder1.addParentStack(MainActivity2.class);
                builder1.addNextIntent(intent);
                PendingIntent pendingIntent=builder1.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(pendingIntent);
                NotificationManager notificationManager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(mId,builder.build());
            }
        if (getIntent().hasExtra(EXTRA_ALARM_TEXT_3)){
                textView.setText("Je hebt een alarm gezet voor het derde uur");
                DeleteButton.setVisibility(View.VISIBLE);
                ButtonNew.setVisibility(View.INVISIBLE);
                ButtonNew.setAlpha(transparentno);
                Context context3=getApplicationContext();
                alarmManager=(AlarmManager) getApplicationContext().getSystemService(Context.ALARM_SERVICE);
                intent3= new Intent(getApplicationContext(),MyService3.class);
                AlarmIntent3=PendingIntent.getService(getApplicationContext(), id3, intent3, PendingIntent.FLAG_UPDATE_CURRENT);


                Calendar calendar3 = Calendar.getInstance();
                calendar3.setTimeInMillis(System.currentTimeMillis());
                calendar3.set(Calendar.HOUR_OF_DAY, 7);
                calendar3.set(Calendar.MINUTE, 45);
                calendar3.add(Calendar.DATE, 1);
                long AlarmTime3=calendar3.getTimeInMillis();

                alarmManager.set(AlarmManager.RTC_WAKEUP, AlarmTime3, AlarmIntent3);

                Notification.Builder builder=new Notification.Builder(this)
                        .setSmallIcon(R.drawable.ic_notification1)
                        .setContentText("Je hebt een alarm gezet voor het derde uur")
                        .setContentTitle("Alarm gezet");
                Intent intent=new Intent(this,MainActivity2.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                String text3="Je hebt een alarm gezet voor het derde uur";
                intent.putExtra(EXTRA_ALARM_TEXT_3, text3);
                TaskStackBuilder builder1=TaskStackBuilder.create(getApplicationContext());
                builder1.addParentStack(MainActivity2.class);
                builder1.addNextIntent(intent);
                PendingIntent pendingIntent=builder1.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(pendingIntent);
                NotificationManager notificationManager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(mId,builder.build());
            }
        if (getIntent().hasExtra(EXTRA_ALARM_SIGNAL)) {
            SilenceButton.setVisibility(View.VISIBLE);
            DeleteButton.setVisibility(View.INVISIBLE);
            ButtonNew.setVisibility(View.INVISIBLE);
            textView.setText("ALARM!!ALARM!!");
        }
        if (getIntent().hasExtra(SHOW_TOAST)) {
                Context context = getApplicationContext();
                CharSequence text = "Alarm is gezet,succes morgen!";
                int duration = Toast.LENGTH_LONG;
                Toast toast3 = Toast.makeText(context, text, duration);
                toast3.show();
            }


        if (getIntent().hasExtra(HOUR)){
                int hourUsed=getIntent().getIntExtra(HOUR,hour);
                int minuteUsed=getIntent().getIntExtra(MINUTE,minute);
                String Label=getIntent().getStringExtra(LABEL);
                textView.setText("Je hebt hiervoor een alarm gezet:" + Label);
                SilenceButton.setVisibility(View.INVISIBLE);
                DeleteButton.setVisibility(View.VISIBLE);
                ButtonNew.setVisibility(View.INVISIBLE);
                Calendar calendar=Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                calendar.set(Calendar.HOUR_OF_DAY, hourUsed);
                calendar.set(Calendar.MINUTE, minuteUsed);
                if (getIntent().hasExtra(TOMORROW)){
                    calendar.add(Calendar.DATE,1);
                }
                long AlarmTime0=calendar.getTimeInMillis();
                intent0=new Intent(this,ElseService.class);
                AlarmIntent0=PendingIntent.getService(getApplicationContext(), id0, intent0, PendingIntent.FLAG_UPDATE_CURRENT);
                alarmManager.set(AlarmManager.RTC_WAKEUP, AlarmTime0, AlarmIntent0);

            }

        }










public void DeleteDialog1(View view) {
    final TextView textView=(TextView)findViewById(R.id.textView2);
    final ImageButton DeleteButton = (ImageButton) findViewById(R.id.ButtonDelete);
    final ImageButton ButtonNew = (ImageButton) findViewById(R.id.ButtonNew);
    final ImageButton SilenceButton = (ImageButton)findViewById(R.id.silence_button);
    Intent intent1 = new Intent(getApplicationContext(),MyService.class);
    Intent intent2a = new Intent(getApplicationContext(),MyService2.class);
    Intent intent3 = new Intent(getApplicationContext(),MyService3.class);
    Intent intent0 = new Intent(getApplicationContext(), ElseService.class);
    AlarmIntent1=PendingIntent.getService(getApplicationContext(),id,intent1,PendingIntent.FLAG_UPDATE_CURRENT);
    alarmManager.cancel(AlarmIntent1);
    AlarmIntent2=PendingIntent.getService(getApplicationContext(),id2,intent2a,PendingIntent.FLAG_UPDATE_CURRENT);
    alarmManager.cancel(AlarmIntent2);
    AlarmIntent3=PendingIntent.getService(getApplicationContext(),id3,intent3,PendingIntent.FLAG_UPDATE_CURRENT);
    alarmManager.cancel(AlarmIntent3);
    AlarmIntent0=PendingIntent.getService(getApplicationContext(),id0,intent0,PendingIntent.FLAG_UPDATE_CURRENT);
    NotificationManager manager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
    manager.cancel(1);
    ButtonNew.setVisibility(View.VISIBLE);
    ButtonNew.animate()
            .alpha(1f)
            .setDuration(duration)
            .setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationStart(Animator animation) {
                    DeleteButton.animate()
                            .setDuration(duration)
                            .alpha(0f)
                            .setListener(new AnimatorListenerAdapter() {

                                @Override
                                public void onAnimationEnd(Animator animation) {
                                    DeleteButton.setVisibility(View.INVISIBLE);
                                }

                            });
                }
            });


    textView.animate()
            .alpha(0f)
            .setDuration(duration)
            .setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    textView.setText(R.string.alarm_set);
                    textView.animate()
                            .alpha(1f)
                            .setDuration(duration)
                            .setListener(null);
                }
            });

    }
    public void StopAlarm(View view){
        final TextView textView=(TextView)findViewById(R.id.textView2);
        final ImageButton DeleteButton = (ImageButton) findViewById(R.id.ButtonDelete);
        DeleteButton.setVisibility(View.INVISIBLE);
        final ImageButton ButtonNew = (ImageButton) findViewById(R.id.ButtonNew);
        final ImageButton SilenceButton=(ImageButton)findViewById(R.id.silence_button);
        ButtonNew.setVisibility(View.VISIBLE);
        ButtonNew.animate()
                .alpha(1f)
                .setDuration(duration)
        .setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                SilenceButton.animate()
                        .setDuration(duration)
                        .alpha(0f)
                        .setListener(new AnimatorListenerAdapter() {

                            @Override
                            public void onAnimationEnd(Animator animation) {
                                SilenceButton.setVisibility(View.INVISIBLE);
                            }

                        });
            }

        });

        textView.animate()
                .alpha(0f)
                .setDuration(duration)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        textView.setText(R.string.alarm_set);
                        textView.animate()
                                .alpha(1f)
                                .setDuration(duration)
                                .setListener(null);
                    }
                });


        String ns=Context.NOTIFICATION_SERVICE;
        NotificationManager notificationManager=(NotificationManager)getApplicationContext().getSystemService(ns);
        notificationManager.cancel(1);
    }


    public void NewScreen1(View view) {
        Intent intent=new Intent(this,ChooseActivity.class);
        startActivity(intent);
        finish();
    }







    @Override
    public void onPause(){
        super.onPause();

    }


    @Override
public void onStop(){
        super.onStop();


}
    public void onResume() {
        super.onResume();
    }

    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);

    }
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }
public void OpenVoiceSearch(){
    Intent intent4=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
    intent4.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,"nl-NL");
    intent4.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, getClass().getPackage().getName());
    try {
        startActivityForResult(intent4,REQUEST_OK);
    }
    catch (Exception e){
        Toast.makeText(getApplicationContext(),"Er is iets misgegaan,probeer het nog eens.",Toast.LENGTH_LONG).show();

    }

}

    @Override
    protected void onActivityResult(int request,int result,Intent i){
        if (result==Activity.RESULT_OK&&request==REQUEST_OK){
            ArrayList<String> commands=i.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            if (commands.contains("Zet een alarm voor het eerste uur")){
                Intent intent=new Intent(this,MainActivity2.class);
                intent.putExtra(EXTRA_ALARM_TEXT_1,"random");
                startActivity(intent);
            }
            else if (commands.contains("Zet een alarm voor het tweede uur")){
                Intent intent1=new Intent(this,MainActivity2.class);
                intent1.putExtra(EXTRA_ALARM_TEXT_2,"random2");
                startActivity(intent1);
            }
            else if (commands.contains("Zet een alarm voor het derde uur")){
                Intent intent0=new Intent(this,MainActivity2.class);
                intent0.putExtra(EXTRA_ALARM_TEXT_3, "random3");
                startActivity(intent0);

            }
            else  Toast.makeText(getApplicationContext(),"Ik heb je verzoek niet goed begrepen, probeer het nog eens.",Toast.LENGTH_LONG).show();

        }
}







    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.mainactivity2, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (item.getItemId()){
            case R.id.action_about:
                Intent intent=new Intent(this,ChooseActivity.class);
                intent.putExtra(MENU_ACTION,"action");
                startActivity(intent);
                return true;
                case R.id.voice_command:
                    OpenVoiceSearch();
                    return true;

    } return super.onOptionsItemSelected(item);

}
}
