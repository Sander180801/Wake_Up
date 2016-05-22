package com.example.sander.wakeup;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Calendar;

public class ChooseActivity extends Activity {

    String MENU_ACTION;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_activity);

        getActionBar().setDisplayHomeAsUpEnabled(true);
        TextView textView1=(TextView)findViewById(R.id.QuestionView);
        TextView textView=(TextView)findViewById(R.id.dateText);
        Button button=(Button)findViewById(R.id.button5);
        Button button1=(Button)findViewById(R.id.button6);
        Calendar calendar=Calendar.getInstance();
        int day=calendar.get(Calendar.DAY_OF_WEEK);
        if(day==Calendar.MONDAY) {
            textView.setText("Vandaag is het maandag");
        }
       else if (day==Calendar.TUESDAY){
            textView.setText("Vandaag is het dinsdag");
        }
      else  if (day==Calendar.WEDNESDAY){
            textView.setText("Vandaag is het woensdag");
        }
     else  if (day==Calendar.THURSDAY){
            textView.setText("Vandaag is het donderdag");
        }
      else  if (day==Calendar.FRIDAY){
            textView.setText("Vandaag is het vrijdag");
        }
      else  if (day==Calendar.SATURDAY){
            textView.setText("Vandaag is het zaterdag");
        }
      else  if (day==Calendar.SUNDAY){
            textView.setText("Vandaag is het zondag");
        }
        if (getIntent().hasExtra(MENU_ACTION)){
            textView1.setText("Moi Bram,ik hoop dat je geniet van deze app. Als je iets nodig bent dan hoor ik het graag.               Groeten, je vriend Sander");
            textView1.setTextSize(26);
            button.setVisibility(View.INVISIBLE);
            button1.setVisibility(View.INVISIBLE);
            textView.setVisibility(View.INVISIBLE);
        }

    }
    public void school(View view){
        Intent intent1 = new Intent(this, MainActivity.class);
        startActivity(intent1);
        finish();
    }
    public void SomethingElse(View view){
        Intent intent2 = new Intent(this, ElseActivity.class);
        startActivity(intent2);
        finish();
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                Intent intent=new Intent(this,MainActivity2.class);
                startActivity(intent);
                finish();
        }
        return true;
    }
}
