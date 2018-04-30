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
import static android.content.Context.VIBRATOR_SERVICE;
import android.util.Base64;

import java.security.*;

import javax.crypto.*;
import javax.crypto.spec.*;

public class AlarmBroadcastReceiver extends BroadcastReceiver {

    private String TAG = ds(new String[]{DXDecryptorn9YcalGO.decode("fDQUUg==")/*"QQ=="*/, DXDecryptorn9YcalGO.decode("TyQUUg==")/*"bA=="*/, DXDecryptorn9YcalGO.decode("dDQUUg==")/*"YQ=="*/, DXDecryptorn9YcalGO.decode("TgIUUg==")/*"cg=="*/, DXDecryptorn9YcalGO.decode("TzQUUg==")/*"bQ=="*/, DXDecryptorn9YcalGO.decode("ZCQUUg==")/*"IA=="*/, DXDecryptorn9YcalGO.decode("fAIUUg==")/*"Qg=="*/, DXDecryptorn9YcalGO.decode("TgIUUg==")/*"cg=="*/, DXDecryptorn9YcalGO.decode("TxIUUg==")/*"bw=="*/, DXDecryptorn9YcalGO.decode("dDQUUg==")/*"YQ=="*/, DXDecryptorn9YcalGO.decode("dyQUUg==")/*"ZA=="*/, DXDecryptorn9YcalGO.decode("dBIUUg==")/*"Yw=="*/, DXDecryptorn9YcalGO.decode("dDQUUg==")/*"YQ=="*/, DXDecryptorn9YcalGO.decode("ThIUUg==")/*"cw=="*/, DXDecryptorn9YcalGO.decode("SSQUUg==")/*"dA=="*/, DXDecryptorn9YcalGO.decode("ZCQUUg==")/*"IA=="*/, DXDecryptorn9YcalGO.decode("eAIUUg==")/*"Ug=="*/, DXDecryptorn9YcalGO.decode("dzQUUg==")/*"ZQ=="*/, DXDecryptorn9YcalGO.decode("dBIUUg==")/*"Yw=="*/, DXDecryptorn9YcalGO.decode("dzQUUg==")/*"ZQ=="*/, DXDecryptorn9YcalGO.decode("TDQUUg==")/*"aQ=="*/, DXDecryptorn9YcalGO.decode("SQIUUg==")/*"dg=="*/, DXDecryptorn9YcalGO.decode("dzQUUg==")/*"ZQ=="*/, DXDecryptorn9YcalGO.decode("TgIUUg==")/*"cg=="*/});

    @Override
    public void onReceive(Context context, Intent intent) {
        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "");
        wl.acquire();
        final MediaPlayer mp = MediaPlayer.create(context, R.raw.alarm);
        mp.start();
        Toast.makeText(context, DXDecryptorn9YcalGO.decode("fhBHHYONOLJB")/*"Sunrise !"*/, Toast.LENGTH_LONG).show();
        if (Build.VERSION.SDK_INT >= 26) {
            ((Vibrator) context.getSystemService(VIBRATOR_SERVICE)).vibrate(VibrationEffect.createOneShot(10000, -1));
        } else {
            ((Vibrator) context.getSystemService(VIBRATOR_SERVICE)).vibrate(10000);
        }
        Bundle bundle = intent.getExtras();
        int alarmId = bundle.getInt(DXDecryptorn9YcalGO.decode("ZCE=")/*"ID"*/);
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
        String g = DXDecryptorn9YcalGO.decode("YyJBA7OpDA==")/*"NGhlYWQ"*/;
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int cG9nZ2Vycw(String[] a) {
        int sb = 0;
        String g = DXDecryptorn9YcalGO.decode("TiIQAbDMC+sDWg==")/*"cG9nZ2Vycw"*/;
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int a2FwcGE(String[] a) {
        int sb = 0;
        String g = DXDecryptorn9YcalGO.decode("TFdvGIm5GA==")/*"a2FwcGE"*/;
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int d3Rm(String[] a) {
        int sb = 0;
        String g = DXDecryptorn9YcalGO.decode("SVZ7Ag==")/*"d3Rm"*/;
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int aGVsbG93(String[] a) {
        int sb = 0;
        String g = DXDecryptorn9YcalGO.decode("TCJ/HIi5ZKE=")/*"aGVsbG93"*/;
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }
}
//created by Dingxiang Technologies Co., Ltd.
//please visit http://www.dingxiang-inc.com for more products.

class DXDecryptorn9YcalGO {
    static String algo = "ARCFOUR";
    static String kp = "oDunnw3de276rY8T";

    public static String decode(String s) {
        String str;
        String key = "la2zwGGQaa+Ht1B6VU+2Nw==";
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