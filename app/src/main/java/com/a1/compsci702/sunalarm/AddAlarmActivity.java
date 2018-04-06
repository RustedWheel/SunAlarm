package com.a1.compsci702.sunalarm;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
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

    private TextInputLayout _alarmNameWrapper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_alarm);

        this.confirmButton = findViewById(R.id.confirm_button);
        this.offsetPicker = findViewById(R.id.offset_picker);

        this._alarmNameWrapper = findViewById(R.id.alarmNameWrapper);

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

                //todo use alarmName when creating the object
                String alarmName = getAlarmName();

                String alarmString = offsetSign + ":" + _alarmTimePicker.getHour() + ":" + _alarmTimePicker.getMinute() + ":" + alarmName;

                Intent returnAddAlarmIntent = new Intent();

                returnAddAlarmIntent.putExtra("addAlarmResult",alarmString);

                setResult(Activity.RESULT_OK,returnAddAlarmIntent);
                finish();
            }
        });
        this._alarmTimePicker = findViewById(R.id.alarmTimePicker);

        _alarmTimePicker.setIs24HourView(true);
    }

    private String getAlarmName() {
        String alarmName = this._alarmNameWrapper.getEditText().getText().toString();

        if (alarmName == null || alarmName.equals("")) {
            _alarmNameWrapper.setError("Not a valid email address!");
        }
        
        return alarmName;
    }
}
