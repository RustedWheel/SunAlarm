package com.a1.compsci702.sunalarm;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TimePicker;
import android.widget.Toast;

public class AddAlarmActivity extends AppCompatActivity {

    private final String TAG = "AddAlarmActivity";
    private Button confirmButton;
    private NumberPicker offsetPicker;

    private TimePicker _alarmTimePicker;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_alarm);

        this.confirmButton = findViewById(R.id.confirm_button);
        this.offsetPicker = findViewById(R.id.offset_picker);



        final String[] offsetStrings = new String[]{"+","-"};
        offsetPicker.setMinValue(0);
        offsetPicker.setMaxValue(offsetStrings.length-1);

        offsetPicker.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int value) {
                return offsetStrings[value];
            }
        });

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.M)
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), offsetStrings[(offsetPicker.getValue())] + "Time:" + _alarmTimePicker.getHour() + _alarmTimePicker.getMinute() , Toast.LENGTH_LONG).show();

                String offsetSign = offsetStrings[(offsetPicker.getValue())];
                String offsetString = offsetSign + " " + _alarmTimePicker.getHour() + ":" + _alarmTimePicker.getMinute();

                Intent returnAddAlarmIntent = new Intent();
                returnAddAlarmIntent.putExtra("addAlarmResult",offsetString);
                setResult(Activity.RESULT_OK,returnAddAlarmIntent);
                finish();
            }
        });
        this._alarmTimePicker = findViewById(R.id.alarmTimePicker);

        _alarmTimePicker.setIs24HourView(true);
    }



}
