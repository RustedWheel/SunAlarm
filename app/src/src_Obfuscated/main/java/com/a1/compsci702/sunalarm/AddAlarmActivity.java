package com.a1.compsci702.sunalarm;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.TimePicker;
import com.a1.compsci702.sunalarm.Utilities.DateConverter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import android.util.Base64;

public class AddAlarmActivity extends AppCompatActivity {

    private final String TAG = ds(new String[]{"QQ==", "ZA==", "ZA==", "QQ==", "bA==", "YQ==", "cg==", "bQ==", "QQ==", "Yw==", "dA==", "aQ==", "dg==", "aQ==", "dA==", "eQ=="});

    private Button confirmButton;

    private NumberPicker offsetPicker;

    private TimePicker _alarmTimePicker;

    private TextInputLayout _alarmNameWrapper;

    private TextView _sunriseTomorrow;

    private TextView _alarmTime;

    private Date _nextSunrise;

    @Override
    @SuppressWarnings("deprecation")
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_alarm);
        this.confirmButton = findViewById(R.id.confirm_button);
        this.offsetPicker = findViewById(R.id.offset_picker);
        this._alarmNameWrapper = findViewById(R.id.alarmNameWrapper);
        this._sunriseTomorrow = findViewById(R.id.sunrise_time_tomorrow);
        this._alarmTime = findViewById(R.id.actual_alarm_time_text);
        retrieveSunrise();
        final String[] offsetStrings = new String[] { "+", "-" };
        offsetPicker.setMinValue(0);
        offsetPicker.setMaxValue(offsetStrings.length - 1);
        offsetPicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        offsetPicker.setDisplayedValues(offsetStrings);
        offsetPicker.setValue(1);
        offsetPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {

            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                changeAlarmTime();
            }
        });
        confirmButton.setOnClickListener(new View.OnClickListener() {

            @TargetApi(Build.VERSION_CODES.M)
            public void onClick(View v) {
                String offsetSign = offsetStrings[(offsetPicker.getValue())];
                Intent returnAddAlarmIntent = new Intent();
                // Call different get time methods according to build API level
                String alarmTime;
                if (Build.VERSION.SDK_INT < 23) {
                    alarmTime = offsetSign + ":" + _alarmTimePicker.getCurrentHour() + ":" + _alarmTimePicker.getCurrentMinute();
                } else {
                    alarmTime = offsetSign + ":" + _alarmTimePicker.getCurrentHour() + ":" + _alarmTimePicker.getCurrentMinute();
                }
                returnAddAlarmIntent.putExtra("alarmTime", alarmTime);
                String alarmName = _alarmNameWrapper.getEditText().getText().toString();
                if (alarmName == null || alarmName.equals("") || alarmName.matches("")) {
                    _alarmNameWrapper.setError("Not a valid alarm name!");
                    return;
                }
                returnAddAlarmIntent.putExtra("alarmName", alarmName);
                setResult(Activity.RESULT_OK, returnAddAlarmIntent);
                finish();
            }
        });
        this._alarmTimePicker = findViewById(R.id.alarmTimePicker);
        _alarmTimePicker.setIs24HourView(true);
        _alarmTimePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {

            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                changeAlarmTime();
            }
        });
        _alarmTimePicker.setCurrentHour(0);
        _alarmTimePicker.setCurrentMinute(0);
    }

    private void retrieveSunrise() {
        // get sunrise time for tomorrow
        Calendar today = Calendar.getInstance();
        today.add(Calendar.DATE, 1);
        String dateTomorrow = DateConverter.dateToString(today.getTime());
        Log.d(TAG, "Date tomorrow is : " + dateTomorrow);
        // change later on to set date of alarm
        SharedPreferences sunriseStorage = getSharedPreferences(Values.SUNRISE_TIME_CACHE, Context.MODE_PRIVATE);
        _nextSunrise = new Date(sunriseStorage.getLong(dateTomorrow, 0L));
        // format date
        SimpleDateFormat formatted = new SimpleDateFormat("hh:mm a");
        _sunriseTomorrow.setText(formatted.format(_nextSunrise));
    }

    private void changeAlarmTime() {
        Calendar c = DateConverter.convertDateToCalendar(_nextSunrise);
        int hour = _alarmTimePicker.getCurrentHour();
        int min = _alarmTimePicker.getCurrentMinute();
        if (offsetPicker.getValue() == 1) {
            hour = -hour;
            min = -min;
        }
        c.add(Calendar.HOUR, hour);
        c.add(Calendar.MINUTE, min);
        // format date
        SimpleDateFormat formatted = new SimpleDateFormat("dd MMM hh:mm a");
        _alarmTime.setText(formatted.format(c.getTime()));
    }

    public static int di(String[] a) {
        StringBuilder sb = new StringBuilder();
        for (String s : a) {
            byte[] d = Base64.decode(s, Base64.DEFAULT);
            String n = new String(d);
            sb.append(Integer.parseInt(n, 2) - 48);
        }
        return Integer.parseInt(sb.toString());
    }

    public static String ds(String[] a) {
        StringBuilder sb = new StringBuilder();
        for (String s : a) {
            byte[] d = Base64.decode(s, Base64.DEFAULT);
            String n = new String(d);
            sb.append(n);
        }
        return sb.toString();
    }

    public static int NGhlYWQ(String[] a) {
        int sb = 0;
        String g = "NGhlYWQ";
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int cG9nZ2Vycw(String[] a) {
        int sb = 0;
        String g = "cG9nZ2Vycw";
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int a2FwcGE(String[] a) {
        int sb = 0;
        String g = "a2FwcGE";
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int d3Rm(String[] a) {
        int sb = 0;
        String g = "d3Rm";
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int aGVsbG93(String[] a) {
        int sb = 0;
        String g = "aGVsbG93";
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }
}
