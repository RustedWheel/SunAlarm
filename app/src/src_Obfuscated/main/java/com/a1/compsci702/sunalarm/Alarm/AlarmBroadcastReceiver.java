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
import android.util.Base64;

public class AlarmBroadcastReceiver extends BroadcastReceiver {

    private String TAG = ds(new String[]{"QQ==", "bA==", "YQ==", "cg==", "bQ==", "IA==", "Qg==", "cg==", "bw==", "YQ==", "ZA==", "Yw==", "YQ==", "cw==", "dA==", "IA==", "Ug==", "ZQ==", "Yw==", "ZQ==", "aQ==", "dg==", "ZQ==", "cg=="});

    @Override
    public void onReceive(Context context, Intent intent) {
        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "");
        wl.acquire();
        final MediaPlayer mp = MediaPlayer.create(context, R.raw.alarm);
        mp.start();
        Toast.makeText(context, "Sunrise !", Toast.LENGTH_LONG).show();
        if (Build.VERSION.SDK_INT >= 26) {
            ((Vibrator) context.getSystemService(VIBRATOR_SERVICE)).vibrate(VibrationEffect.createOneShot(10000, -1));
        } else {
            ((Vibrator) context.getSystemService(VIBRATOR_SERVICE)).vibrate(10000);
        }
        Bundle bundle = intent.getExtras();
        int alarmId = bundle.getInt("ID");

        Storage storage = new Storage();
        storage.deleteAlarm(context, alarmId);
        wl.release();
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
