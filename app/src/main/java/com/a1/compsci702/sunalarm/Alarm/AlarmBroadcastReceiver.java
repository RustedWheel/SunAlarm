package com.a1.compsci702.sunalarm.Alarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.widget.Toast;

import com.a1.compsci702.sunalarm.R;
import com.a1.compsci702.sunalarm.Utilities.Storage;

import static android.content.Context.VIBRATOR_SERVICE;

/**
 * Created by David on 2018/3/22.
 */

public class AlarmBroadcastReceiver extends BroadcastReceiver
{

    private String TAG = "Alarm Broadcast Receiver";

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

        Bundle bundle = intent.getExtras();
        int alarmId = bundle.getInt("ID");
        Log.d(TAG, "Alarm triggered, ID : " + alarmId);
        Storage storage = new Storage();
        storage.deleteAlarm(context, alarmId);

        wl.release();
    }

}