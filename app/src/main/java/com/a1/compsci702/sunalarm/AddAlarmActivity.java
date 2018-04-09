package com.a1.compsci702.sunalarm;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.text.format.Time;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.a1.compsci702.sunalarm.Utilities.DateConverter;
import com.codetroopers.betterpickers.recurrencepicker.EventRecurrence;
import com.codetroopers.betterpickers.recurrencepicker.EventRecurrenceFormatter;
import com.codetroopers.betterpickers.recurrencepicker.RecurrencePickerDialogFragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class AddAlarmActivity extends AppCompatActivity implements RecurrencePickerDialogFragment.OnRecurrenceSetListener {

    private final String TAG = "AddAlarmActivity";
    private Button confirmButton;
    private NumberPicker offsetPicker;

    private TimePicker _alarmTimePicker;

    private TextInputLayout _alarmNameWrapper;

    private Button _repeatButton;

    private static final String FRAG_TAG_RECUR_PICKER = "recurrencePickerDialogFragment";
    private EventRecurrence mEventRecurrence = new EventRecurrence();
    private String mRrule;

    private TextView _sunriseTomorrow;

    private String _repeatString;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_alarm);

        this.confirmButton = findViewById(R.id.confirm_button);

        this.offsetPicker = findViewById(R.id.offset_picker);

        this._repeatButton = findViewById(R.id.repeat_button);

        this._alarmNameWrapper = findViewById(R.id.alarmNameWrapper);
        this._sunriseTomorrow = findViewById(R.id.sunrise_time_tomorrow);

        retrieveSunrise();

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

                Intent returnAddAlarmIntent = new Intent();

                String alarmTime = offsetSign + ":" + _alarmTimePicker.getHour() + ":" + _alarmTimePicker.getMinute();
                returnAddAlarmIntent.putExtra("alarmTime", alarmTime);


                String alarmName = _alarmNameWrapper.getEditText().getText().toString();

                if (alarmName == null || alarmName.equals("") || alarmName.matches("")) {
                    _alarmNameWrapper.setError("Not a valid alarm name!");
                    return;
                }
                returnAddAlarmIntent.putExtra("alarmName", alarmName);

                returnAddAlarmIntent.putExtra("repeat", _repeatString);

                Log.d(TAG, "Repeat information from the picker: " + _repeatString);

                setResult(Activity.RESULT_OK,returnAddAlarmIntent);

                finish();
            }
        });

        /*
        From: https://github.com/code-troopers/android-betterpickers/blob/master/sample/src/main/java/com/codetroopers/betterpickers/sample/activity/recurrencepicker/SampleRecurrenceBasicUsage.java
         */
        _repeatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                Bundle bundle = new Bundle();
                Time time = new Time();
                time.setToNow();
                bundle.putLong(RecurrencePickerDialogFragment.BUNDLE_START_TIME_MILLIS, time.toMillis(false));
                bundle.putString(RecurrencePickerDialogFragment.BUNDLE_TIME_ZONE, time.timezone);

                // may be more efficient to serialize and pass in EventRecurrence
                bundle.putString(RecurrencePickerDialogFragment.BUNDLE_RRULE, mRrule);

                RecurrencePickerDialogFragment rpd = (RecurrencePickerDialogFragment) fm.findFragmentByTag(
                        FRAG_TAG_RECUR_PICKER);
                if (rpd != null) {
                    rpd.dismiss();
                }
                rpd = new RecurrencePickerDialogFragment();
                rpd.setArguments(bundle);
                rpd.setOnRecurrenceSetListener(AddAlarmActivity.this);
                rpd.show(fm, FRAG_TAG_RECUR_PICKER);
            }
        });


        this._alarmTimePicker = findViewById(R.id.alarmTimePicker);

        _alarmTimePicker.setIs24HourView(true);
    }

    private void retrieveSunrise() {
        //get sunrise time for tomorrow
        Calendar today = Calendar.getInstance();
        today.add(Calendar.DATE, 1);
        String dateTomorrow = DateConverter.dateToString(today.getTime());
        Log.d(TAG, "Date tomorrow is : " + dateTomorrow);

        //change later on to set date of alarm
        SharedPreferences sunriseStorage = getSharedPreferences(Values.SUNRISE_TIME_CACHE, Context.MODE_PRIVATE);
        Date nextSunrise = new Date(sunriseStorage.getLong(dateTomorrow, 0L));

        //format date
        SimpleDateFormat formatted = new SimpleDateFormat("hh:mm a");

        _sunriseTomorrow.setText(formatted.format(nextSunrise));
    }

    @Override
    public void onRecurrenceSet(String rrule) {
        mRrule = rrule;
        if (mRrule != null) {
            mEventRecurrence.parse(mRrule);
        }
        populateRepeats();
    }

    private void populateRepeats() {
        Resources r = getResources();

        if (!TextUtils.isEmpty(mRrule)) {
            this._repeatString = EventRecurrenceFormatter.getRepeatString(this, r, mEventRecurrence, true);
        }
    }
}
