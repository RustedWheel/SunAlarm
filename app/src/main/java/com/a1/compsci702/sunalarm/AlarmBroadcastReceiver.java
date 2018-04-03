package com.a1.compsci702.sunalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.PowerManager;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.widget.Toast;

import static android.content.Context.VIBRATOR_SERVICE;

/**
 * Created by David on 2018/3/22.
 */

public class AlarmBroadcastReceiver extends BroadcastReceiver
{

    @Override
    public void onReceive(Context context, Intent intent)
    {
        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "");
        wl.acquire();

        final MediaPlayer mp = MediaPlayer.create(context, R.raw.alarm);
        mp.start();

        // Better to play a video animation i guess?
        Toast.makeText(context, "Sunrise !", Toast.LENGTH_LONG).show();

        if (Build.VERSION.SDK_INT >= 26) {
            ((Vibrator) context.getSystemService(VIBRATOR_SERVICE)).vibrate(VibrationEffect.createOneShot(10000,-1));
        } else {
            ((Vibrator) context.getSystemService(VIBRATOR_SERVICE)).vibrate(10000);
        }

        wl.release();
    }

}