package com.a1.compsci702.sunalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.os.Build;
import android.os.PowerManager;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.widget.Toast;

import static android.content.Context.VIBRATOR_SERVICE;

/**
 * Created by David on 2018/3/22.
 */

public class Alarm extends BroadcastReceiver
{

    @Override
    public void onReceive(Context context, Intent intent)
    {
        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "");
        wl.acquire();

        // Better to play a video animation i guess?
        Toast.makeText(context, "Sunrise !", Toast.LENGTH_LONG).show();

        if (Build.VERSION.SDK_INT >= 26) {
            ((Vibrator) context.getSystemService(VIBRATOR_SERVICE)).vibrate(VibrationEffect.createOneShot(10000,-1));
        } else {
            ((Vibrator) context.getSystemService(VIBRATOR_SERVICE)).vibrate(10000);
        }

        wl.release();
    }

    public void setAlarm(Context context, int seconds)
    {
        /*AlarmManager am =( AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, Alarm.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);*/
        //am.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 1000 * 60 * 10, pendingIntent); // Millisec * Second * Minute
        //am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()* seconds * 1000, pendingIntent);
        Intent intent = new Intent(context, Alarm.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context,0, intent,0);
        AlarmManager am = (AlarmManager)context.getSystemService(context.ALARM_SERVICE);
        am.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis() + seconds * 1000, pendingIntent );
    }

    public void cancelAlarm(Context context)
    {
        Intent intent = new Intent(context, Alarm.class);
        PendingIntent sender = PendingIntent.getBroadcast(context, 0, intent, 0);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(sender);
    }
}