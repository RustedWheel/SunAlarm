package com.a1.compsci702.sunalarm.Utilities;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.*;
import android.util.Log;

import com.a1.compsci702.sunalarm.Alarm.Alarm;
import com.a1.compsci702.sunalarm.Values;
import com.google.gson.Gson;

import java.security.*;
import java.util.Date;

import javax.crypto.*;
import javax.crypto.spec.*;

public final class Storage {

    public void saveAlarm(Context context, Alarm alarm) {

        SharedPreferences alarmsStorage = context.getSharedPreferences(Values.STORED_ALARMS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = alarmsStorage.edit();
        Gson gson = new Gson();
        String json = gson.toJson(alarm);
        editor.putString(String.valueOf(alarm.getId()), json);
        editor.apply();
        Log.d(DXDecryptorhL2ez6LR.decode("V0NWPiHPSwXRUQ==")/*"SAVE_ALARM"*/, DXDecryptorhL2ez6LR.decode("RW5hCROuZjCjJrA=")/*"Alarm at : "*/ + alarm.getAlarmTime().toString() + DXDecryptorhL2ez6LR.decode("JHF0FAzrY2Tib7AJ88xpD3xB")/*" stored as Long : "*/ + alarm.getAlarmTime().getTime());
        Log.d(DXDecryptorhL2ez6LR.decode("V0NWPiHPSwXRUQ==")/*"SAVE_ALARM"*/, DXDecryptorhL2ez6LR.decode("RW5hCROuTRfMUrB/vA==")/*"Alarm JSON : "*/ + json);
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
        Log.d(DXDecryptorhL2ez6LR.decode("VkdNNCjLWAvPWM8B3fZLfA==")/*"REMOVE_OLD_DATES"*/, DXDecryptorhL2ez6LR.decode("VmdtFAjnaSOjeeg19dBrS2YFykZ1p8B0XQ==")/*"Removing expired date: : "*/ + date);
        editor.apply();
    }


    public int getNextAlarmID(Context context) {
        SharedPreferences alarmStorage = context.getSharedPreferences(Values.ALARM_ID, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = alarmStorage.edit();
        int id = alarmStorage.getInt(DXDecryptorhL2ez6LR.decode("TUY=")/*"ID"*/, 0) + 1;
        editor.putInt(DXDecryptorhL2ez6LR.decode("TUY=")/*"ID"*/, id);
        editor.apply();
        return id;
    }

}
//created by Dingxiang Technologies Co., Ltd.
//please visit http://www.dingxiang-inc.com for more products.

class DXDecryptorhL2ez6LR {
    static String algo = "ARCFOUR";
    static String kp = "kcoyyjehPJX1l0nj";

    public static String decode(String s) {
        String str;
        String key = "+Z9E07/CWJhrBZ43PMdF1w==";
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