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
import android.util.Base64;

public final class Storage {

    public void saveAlarm(Context context, Alarm alarm) {
        SharedPreferences alarmsStorage = context.getSharedPreferences(Values.STORED_ALARMS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = alarmsStorage.edit();
        Gson gson = new Gson();
        String json = gson.toJson(alarm);
        editor.putString(String.valueOf(alarm.getId()), json);
        editor.apply();
        Log.d(DXDecryptorhL2ez6LR.decode("V0NWPiHPSwXRUQ=="), /*"SAVE_ALARM"*/
        DXDecryptorhL2ez6LR.decode("RW5hCROuZjCjJrA=") + /*"Alarm at : "*/
        alarm.getAlarmTime().toString() + DXDecryptorhL2ez6LR.decode("JHF0FAzrY2Tib7AJ88xpD3xB") + /*" stored as Long : "*/
        alarm.getAlarmTime().getTime());
        Log.d(DXDecryptorhL2ez6LR.decode("V0NWPiHPSwXRUQ=="), /*"SAVE_ALARM"*/
        DXDecryptorhL2ez6LR.decode("RW5hCROuTRfMUrB/vA==") + /*"Alarm JSON : "*/
        json);
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
        Log.d(DXDecryptorhL2ez6LR.decode("VkdNNCjLWAvPWM8B3fZLfA=="), /*"REMOVE_OLD_DATES"*/
        DXDecryptorhL2ez6LR.decode("VmdtFAjnaSOjeeg19dBrS2YFykZ1p8B0XQ==") + /*"Removing expired date: : "*/
        date);
        editor.apply();
    }

    public int getNextAlarmID(Context context) {
        SharedPreferences alarmStorage = context.getSharedPreferences(Values.ALARM_ID, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = alarmStorage.edit();
        int id = alarmStorage.getInt(DXDecryptorhL2ez6LR.decode("TUY="), /*"ID"*/
        0) + 1;
        editor.putInt(DXDecryptorhL2ez6LR.decode("TUY="), /*"ID"*/
        id);
        editor.apply();
        return id;
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

class DXDecryptorhL2ez6LR {

    static String algo = ds(new String[]{"QQ==", "Ug==", "Qw==", "Rg==", "Tw==", "VQ==", "Ug=="});

    static String kp = ds(new String[]{"aw==", "Yw==", "bw==", "eQ==", "eQ==", "ag==", "ZQ==", "aA==", "UA==", "Sg==", "WA==", "MQ==", "bA==", "MA==", "bg==", "ag=="});

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
