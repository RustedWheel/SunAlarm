package com.a1.compsci702.sunalarm.Utilities;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.a1.compsci702.sunalarm.Alarm.Alarm;
import com.a1.compsci702.sunalarm.Values;
import com.google.gson.Gson;

import java.util.Date;

public final class Storage {

    public void saveAlarm(Context context, Alarm alarm) {

        SharedPreferences alarmsStorage = context.getSharedPreferences(Values.STORED_ALARMS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = alarmsStorage.edit();
        Gson gson = new Gson();
        String json = gson.toJson(alarm);
        editor.putString(String.valueOf(alarm.getId()), json);
        editor.apply();
        Log.d("SAVE_ALARM", "Alarm at : " + alarm.getAlarmTime().toString() + " stored as Long : " + alarm.getAlarmTime().getTime());
        Log.d("SAVE_ALARM", "Alarm JSON : " + json);
    }

    public void deleteAlarm(Context context, int alarmID) {

        SharedPreferences alarmsStorage = context.getSharedPreferences(Values.STORED_ALARMS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = alarmsStorage.edit();
        editor.remove(String.valueOf(alarmID));
        editor.apply();

    }

    public void saveSunriseTime(Context context, Date time) {
        SharedPreferences sunriseStorage = context.getSharedPreferences(Values.SUNRISE_TIME_CACHE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sunriseStorage.edit();
        editor.putLong(DateConverter.dateToString(time), time.getTime());
        editor.commit();
    }

    public void removeSunriseTime(Context context, String date) {
        SharedPreferences sunriseStorage = context.getSharedPreferences(Values.SUNRISE_TIME_CACHE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sunriseStorage.edit();
        editor.remove(date);
        Log.d("REMOVE_OLD_DATES", "Removing expired date: : " + date);
        editor.apply();
    }


    public int getNextAlarmID(Context context) {
        SharedPreferences alarmStorage = context.getSharedPreferences(Values.ALARM_ID, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = alarmStorage.edit();
        int id = alarmStorage.getInt("ID", 0) + 1;
        editor.putInt("ID", id);
        editor.apply();
        return id;
    }

}
