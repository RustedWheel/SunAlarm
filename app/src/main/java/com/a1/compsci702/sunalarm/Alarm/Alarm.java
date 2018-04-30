package com.a1.compsci702.sunalarm.Alarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.*;

import com.a1.compsci702.sunalarm.Utilities.DateConverter;

import java.security.*;
import java.util.Calendar;
import java.util.Date;

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
        intent.putExtra(DXDecryptorTGjsY35f.decode("SWg=")/*"ID"*/, _alarmId);
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
}
//created by Dingxiang Technologies Co., Ltd.
//please visit http://www.dingxiang-inc.com for more products.

class DXDecryptorTGjsY35f {
    static String algo = "ARCFOUR";
    static String kp = "JJ1VuXNeWRMew8Qr";

    public static String decode(String s) {
        String str;
        String key = "6MgSXnUxcFLPgBDzPiLSzw==";
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