package com.example.zzz.datepickertimepickertest;

import android.support.v7.app.AppCompatActivity;
import java.util.Calendar;
import android.os.Bundle;
import android.view.Menu;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;


public class MainActivity extends AppCompatActivity {
    private DatePicker datepicker;
    private TimePicker timepicker;
    private EditText edittext;
    private int Year;
    private int Month;
    private int Day;
    private int Hour;
    private int Minute;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datepicker = (DatePicker) findViewById(R.id.datepicker);
        timepicker = (TimePicker) findViewById(R.id.timepicker);
        edittext = (EditText) findViewById(R.id.edittext);
        Calendar c = Calendar.getInstance();
        Year = c.get(Calendar.YEAR);
        Month = c.get(Calendar.MONTH);
        Day = c.get(Calendar.DAY_OF_MONTH);
        Hour = c.get(Calendar.HOUR);
        Minute = c.get(Calendar.MINUTE);

        datepicker.init(Year, Month, Day, new DatePicker.OnDateChangedListener() {
            public void onDateChanged(DatePicker view, int year, int month, int day) {
                Year=year;
                Month=month;
                Day=day;
                show(Year,Month+1,Day,Hour,Minute);
            }
        });
        timepicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hour, int minute) {
                Hour=hour;
                Minute=minute;
                show(Year,Month+1,Day,Hour,Minute);
            }
        });
    }
    private void show(int year,int month,int day,int hour,int minute){
        edittext.setText("您选择的日期时间为："+year+"年"+month+"月"+day+"日"+hour+"时"+minute+"分");
    }
    public boolean onCreatOptionsMenu(Menu menu){
        //Inflate the menu;this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }
}
