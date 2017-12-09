package com.example.wojtek.taskreminder.activity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v4.app.Fragment;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.wojtek.taskreminder.R;

import java.text.DateFormat;
import java.util.Calendar;


public class add extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Button time = (Button) findViewById(R.id.btntime);
        Button date = (Button) findViewById(R.id.btndate);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment datepicker = new DatePickerFragment();
                datepicker.show(getSupportFragmentManager(),"date picker");
            }
        });

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DialogFragment timepicker = new TimePickerFragment();
                timepicker.show(getSupportFragmentManager(),"time picker");



            }
        });

    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, i);
        c.set(Calendar.MONTH, i1);
        c.set(Calendar.DAY_OF_MONTH, i2);
        String currentdatestring = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
        TextView textView =(TextView)findViewById(R.id.date);
        textView.setText(currentdatestring);
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        TextView textView =(TextView)findViewById(R.id.time);
   textView.setText(i + ":" + i1);
    }



    public void onBackPressed() {
        finish();
    }
}
