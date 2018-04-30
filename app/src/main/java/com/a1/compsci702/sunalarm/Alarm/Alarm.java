package com.a1.compsci702.sunalarm.Alarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.a1.compsci702.sunalarm.Utilities.DateConverter;

import java.security.*;
import java.util.Calendar;
import java.util.Date;

import android.util.*;
import android.util.Base64;

import javax.crypto.*;
import javax.crypto.spec.*;

public class Alarm {

    private String _name;

    private int _alarmId;

    private Date _alarmTime;

    private AlarmType.type _type;

    public Alarm(String name, int alarmId, Date alarmTime, AlarmType.type type) {
        _name = name;
        _alarmId = alarmId;
        _alarmTime = alarmTime;
        _type = type;
    }

    public void setAlarm(Context context) {
        Calendar c = DateConverter.convertDateToCalendar(_alarmTime);
        Intent intent = new Intent(context, AlarmBroadcastReceiver.class);
        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        intent.putExtra(DXDecryptorjZ7czya6.decode("XYw=")/*"ID"*/, _alarmId);
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

    public int getId() {
        return _alarmId;
    }

    public Date getAlarmTime() {
        return _alarmTime;
    }

    public String getName() {
        return _name;
    }

    public AlarmType.type getType() {
        return _type;
    }

    public String toString() {
        return this._name;
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
        String g = DXDecryptorjZ7czya6.decode("Wo927iTckQ==")/*"NGhlYWQ"*/;
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int cG9nZ2Vycw(String[] a) {
        int sb = 0;
        String g = DXDecryptorjZ7czya6.decode("d48n7Ce5lgumrA==")/*"cG9nZ2Vycw"*/;
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int a2FwcGE(String[] a) {
        int sb = 0;
        String g = DXDecryptorjZ7czya6.decode("dfpY9R7MhQ==")/*"a2FwcGE"*/;
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int d3Rm(String[] a) {
        int sb = 0;
        String g = DXDecryptorjZ7czya6.decode("cPtM7w==")/*"d3Rm"*/;
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int aGVsbG93(String[] a) {
        int sb = 0;
        String g = DXDecryptorjZ7czya6.decode("dY9I8R/M+UE=")/*"aGVsbG93"*/;
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

class DXDecryptorjZ7czya6 {
    static String algo = "ARCFOUR";
    static String kp = "IBBWB1RXypjHTM3M";

    public static String decode(String s) {
        String str;
        String key = "VbKwVdujUDh1Knl6pivAsA==";
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