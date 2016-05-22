package com.example.sander.wakeup;


import android.app.Activity;

import android.app.AlarmManager;
import android.content.Context;

import android.content.Intent;
import android.os.Bundle;


import android.provider.AlarmClock;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends Activity {

String EXTRA_ALARM_TEXT_1="AText1";
    String EXTRA_ALARM_TEXT_2="AText2";
    String EXTRA_ALARM_TEXT_3="AText3";
    String SHOW_TOAST;
    int  SET_ALARM_1;
    int SET_ALARM_2;
    int SET_ALARM_3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActionBar().setDisplayHomeAsUpEnabled(true);

    }
public void CreateDialog1(View view){

    Intent intent2=new Intent(this,MainActivity2.class);
    String text="Je hebt een alarm gezet voor het eerste uur";
    intent2.putExtra(EXTRA_ALARM_TEXT_1, text);
    String toast="Show Toast";
    intent2.putExtra(SHOW_TOAST,toast);




            if (intent2.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(intent2,SET_ALARM_1);
                finish();

            }
        }









    public void CreateDialog2(View view) {
        Context context2=getApplicationContext();



        Intent intent2B = new Intent(this,MainActivity2.class);
        String text = "Je hebt een alarm gezet voor het tweede uur";
        intent2B.putExtra(EXTRA_ALARM_TEXT_2, text);
        String toast="Show Toast";
        intent2B.putExtra(SHOW_TOAST,toast);

              if (intent2B.resolveActivity(getPackageManager()) != null) {
                  startActivityForResult(intent2B,SET_ALARM_2);
                  finish();

              }

          }




    public void CreateDialog3(View view){



        Intent intent3B=new Intent(this,MainActivity2.class);
        String text="Je hebt een alarm gezet voor het derde uur";
        intent3B.putExtra(EXTRA_ALARM_TEXT_3, text);
        String toast="Show Toast";
        intent3B.putExtra(SHOW_TOAST,toast);

                if (intent3B.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(intent3B,SET_ALARM_3);
                    finish();

                }
                }



    public void onPause(){
        super.onPause();
    }
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
    }
    public void onStop(){
        super.onStop();
    }
    public void onRestart(){
        super.onRestart();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (item.getItemId()){
            case android.R.id.home:
                Intent intent=new Intent(this,ChooseActivity.class);
                startActivity(intent);
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
