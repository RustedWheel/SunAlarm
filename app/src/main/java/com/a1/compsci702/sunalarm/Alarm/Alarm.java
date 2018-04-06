package com.a1.compsci702.sunalarm.Alarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import com.a1.compsci702.sunalarm.Utilities.DateConverter;

import java.util.Calendar;
import java.util.Date;

public class Alarm {

    private static final String TAG = "Alarm";
    private String _name;
    private int _alarmId;
    private Date _alarmTime;
    private boolean _snooze;
    private boolean _repeat;
    private AlarmType.type _type;

    public Alarm(String name, int alarmId, Date alarmTime, boolean snooze, boolean repeat, AlarmType.type type) {

        _name = name;
        _alarmId = alarmId;
        _alarmTime = alarmTime;
        _snooze = snooze;
        _repeat = repeat;
        _type = type;

    }


    public void setAlarmTime(Date date){
        _alarmTime = date;
    }


    public void setAlarm(Context context){

            Calendar c = DateConverter.convertDateToCalendar(_alarmTime);
            Intent intent = new Intent(context, AlarmBroadcastReceiver.class);
            intent.putExtra("ID", _alarmId);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, _alarmId, intent, 0);
            AlarmManager am = (AlarmManager) context.getSystemService(context.ALARM_SERVICE);
            am.set(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pendingIntent);

    }


    public void cancelAlarm(Context context) {

        Intent intent = new Intent(context, Alarm.class);
        PendingIntent sender = PendingIntent.getBroadcast(context, _alarmId, intent, 0);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(sender);

    }

    public int getId(){
        return _alarmId;
    }


    public Date getAlarmTime(){
        return _alarmTime;
    }


    public String getName(){
        return _name;
    }


    public boolean isSnooze(){
        return _snooze;
    }


    public boolean isRepeat(){
        return _repeat;
    }


    public AlarmType.type getType(){
        return _type;
    }

    public String toString() {
        return this._alarmTime.toString();
    }
}
