package com.example.sander.wakeup;


import android.app.ActionBar;
import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.CalendarContract;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.io.StringReader;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ElseActivity extends Activity implements TimePickerDialog.OnTimeSetListener {

   static String HOUR;
  static String MINUTE;
    String LABEL;
    String TODAY;
    String TOMORROW;




    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_else);
        getActionBar().setDisplayHomeAsUpEnabled(true);
            }
    public void changeTime(View view){
        Calendar c=Calendar.getInstance();
        int hour=c.get(Calendar.HOUR_OF_DAY);
        int minute=c.get(Calendar.MINUTE)+1;
        TimePickerDialog dialog=new TimePickerDialog(this,this,hour,minute,true);
        dialog.setButton(TimePickerDialog.BUTTON_NEGATIVE, "Annuleer", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        dialog.setMessage("Kies je tijdstip");
        dialog.setCancelable(true);
        dialog.show();

    }
    public void onTimeSet(TimePicker picker,int hour,int minute){
        if (picker.isShown()){
            EditText editText=(EditText)findViewById(R.id.editTextLabel);
            RadioButton radioButton=(RadioButton)findViewById(R.id.radioButton);
            RadioButton radioButton1=(RadioButton)findViewById(R.id.radioButton2);
            boolean checked=radioButton.isChecked();
            boolean checked1=radioButton1.isChecked();
            String Label=editText.getText().toString().trim();
            if (TextUtils.isEmpty(Label)){
                Toast.makeText(getApplicationContext(),"Je hebt geen reden gegeven voor dit alarm!",Toast.LENGTH_LONG).show();
            }
            Intent intent=new Intent(this,MainActivity2.class);
            hour=picker.getCurrentHour();
            minute=picker.getCurrentMinute();
            intent.putExtra(HOUR,hour);
            intent.putExtra(MINUTE, minute);
            intent.putExtra(LABEL,Label);
            if (checked1){
                intent.putExtra(TOMORROW,"tomorrow");
            }
            startActivity(intent);
            finish();
        }

    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                Intent intent=new Intent(this,ChooseActivity.class);
                startActivity(intent);
                finish();
        }
        return true;
    }

}




