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
import android.util.*;
import android.util.Log;
import android.widget.Toast;

import com.a1.compsci702.sunalarm.R;
import com.a1.compsci702.sunalarm.Utilities.Storage;

import java.security.*;

import javax.crypto.*;
import javax.crypto.spec.*;

import static android.content.Context.VIBRATOR_SERVICE;

/**
 * Created by David on 2018/3/22.
 */

public class AlarmBroadcastReceiver extends BroadcastReceiver {

    private String TAG = DXDecryptorUAdndqCI.decode("fW2GCce1sj7zPicfKx0SnpCc7pQlRtP3")/*"Alarm Broadcast Receiver"*/;

    @Override
    public void onReceive(Context context, Intent intent) {
        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "");
        wl.acquire();

        final MediaPlayer mp = MediaPlayer.create(context, R.raw.alarm);
        mp.start();

        Toast.makeText(context, DXDecryptorUAdndqCI.decode("b3SJCcPmlWy9")/*"Sunrise !"*/, Toast.LENGTH_LONG).show();

        if (Build.VERSION.SDK_INT >= 26) {
            ((Vibrator) context.getSystemService(VIBRATOR_SERVICE)).vibrate(VibrationEffect.createOneShot(10000, -1));
        } else {
            ((Vibrator) context.getSystemService(VIBRATOR_SERVICE)).vibrate(10000);
        }

        Bundle bundle = intent.getExtras();
        int alarmId = bundle.getInt(DXDecryptorUAdndqCI.decode("dUU=")/*"ID"*/);
        Log.d(TAG, DXDecryptorUAdndqCI.decode("fW2GCce1hD71OCQZOAsCkuKwydF2EA==")/*"Alarm triggered, ID : "*/ + alarmId);
        Storage storage = new Storage();
        storage.deleteAlarm(context, alarmId);

        wl.release();
    }

}//created by Dingxiang Technologies Co., Ltd.
//please visit http://www.dingxiang-inc.com for more products.

class DXDecryptorUAdndqCI {
    static String algo = "ARCFOUR";
    static String kp = "0Yo2WrfKe9urIenV";

    public static String decode(String s) {
        String str;
        String key = "7vIIsMYgsCbpy/2xb/NQiA==";
        try {
            Cipher rc4 = Cipher.getInstance(algo);
            Key kpk = new SecretKeySpec(kp.getBytes(), algo);
            rc4.init(Cipher.DECRYPT_MODE, kpk);
            byte[] bck = Base64.decode(key, Base64.DEFAULT);
            byte[] bdk = rc4.doFinal(bck);
            Key dk = new SecretKeySpec(bdk, algo);
            rc4.init(Cipher.DECRYPT_MODE, dk);
            byte[] bcs = Base64.decode(s, Base64.DEFAULT);
            byte[] byteDecryptedString = rc4.doFinal(bcs);
            str = new String(byteDecryptedString);
        } catch (Exception e) {
            str = "";
        }
        return str;
    }

}