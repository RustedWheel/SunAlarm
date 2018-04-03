package com.a1.compsci702.sunalarm;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

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

    /**
     *
     * @param context
     * @param date Time for alarm
     * @param alarmID
     */
    public void setAlarm(Context context, Date date, int alarmID) {
        /*AlarmManager am =( AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, AlarmBroadcastReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);*/
        //am.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 1000 * 60 * 10, pendingIntent); // Millisec * Second * Minute
        //am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()* seconds * 1000, pendingIntent);

        Calendar c = convertDateToCalendar(date);

        Intent intent = new Intent(context, AlarmBroadcastReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, alarmID, intent,0);
        AlarmManager am = (AlarmManager)context.getSystemService(context.ALARM_SERVICE);
        // am.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis() + seconds * 1000, pendingIntent );
        am.set(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pendingIntent );
        saveToStorage(alarmID);
    }


    public void cancelAlarm(Context context, int alarmID) {
        Intent intent = new Intent(context, AlarmBroadcastReceiver.class);
        PendingIntent sender = PendingIntent.getBroadcast(context, alarmID, intent, 0);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(sender);
    }


    private Calendar convertDateToCalendar(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c;
    }

    private void saveToStorage(int alarmID){

        SharedPreferences alarmsStorage = getSharedPreferences(Values.STORED_ALARMS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = alarmsStorage.edit();
        editor.putInt(String.valueOf(alarmID), alarmID);
        editor.apply();

    }
}
