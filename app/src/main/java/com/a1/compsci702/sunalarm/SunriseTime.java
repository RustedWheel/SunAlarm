package com.a1.compsci702.sunalarm;

import android.location.Location;
import android.util.*;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.security.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import javax.crypto.*;
import javax.crypto.spec.*;
import android.util.Base64;

public class SunriseTime {

    private final String s1 = DXDecryptor58RdZsvS.decode("jm6Oy9cJKzHlUuLJc2mhaCDVHFVSzli4U6XawT+MdVmod/1mO3on+g==");

    private final String s2 = DXDecryptor58RdZsvS.decode("wHaU3Jk=");

    private final String s3 = DXDecryptor58RdZsvS.decode("wH6bz8EO");

    private final String s4 = DXDecryptor58RdZsvS.decode("yw==");

    private final String s5 = DXDecryptor58RdZsvS.decode("wHyVyclScGrhRrbX");

    private final String TAG = DXDecryptor58RdZsvS.decode("tW+Uyc1AYUrtT+4=");

    public SunriseTime() {
    }

    public Date getSunriseTime(Location location, Date date) throws IOException {
        StringBuilder sb = new StringBuilder(s1);
        sb.append(location.getLatitude());
        sb.append(s2);
        sb.append(location.getLongitude());
        sb.append(s3);
        sb.append(date.getYear() + 1900);
        sb.append(s4);
        sb.append(date.getMonth() + 1);
        sb.append(s4);
        sb.append(date.getDate());
        sb.append(s5);
        HTTPRequest request = new HTTPRequest(sb.toString());
        String rawJSON = request.makeGetRequest();
        Log.d(TAG, DXDecryptor58RdZsvS.decode("rEm19Z4T") + /*"JSON: "*/
        rawJSON);
        ProcessJSON processJSON = new ProcessJSON();
        JSONObject response = processJSON.stringToJSON(rawJSON);
        String result = "";
        try {
            JSONObject results = response.getJSONObject(DXDecryptor58RdZsvS.decode("lH+JzshHdw=="));
            result = results.getString(DXDecryptor58RdZsvS.decode("lW+Uyc1AYQ=="));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        result = result.substring(0, 19);
        DateFormat utcTime = new SimpleDateFormat(DXDecryptor58RdZsvS.decode("n2ODwol+STPgRqyzJ1SHICTLQwtS"));
        utcTime.setTimeZone(TimeZone.getTimeZone(DXDecryptor58RdZsvS.decode("s065")));
        Date utcDate = null;
        try {
            utcDate = utcTime.parse(result);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DateFormat currentTime = new SimpleDateFormat(DXDecryptor58RdZsvS.decode("n2ODwol+STPgRqyzJ1SHICTLQwtS"));
        currentTime.setTimeZone(TimeZone.getDefault());
        String s = currentTime.format(utcDate);
        Log.d(TAG, s);
        Date convertedDate = null;
        try {
            convertedDate = currentTime.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Log.d(TAG, convertedDate.toString());
        return convertedDate;
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

class DXDecryptor58RdZsvS {

    static String algo = ds(new String[]{"QQ==", "Ug==", "Qw==", "Rg==", "Tw==", "VQ==", "Ug=="});

    static String kp = ds(new String[]{"TQ==", "Mw==", "Wg==", "bQ==", "Yw==", "eQ==", "MA==", "Tw==", "bw==", "VQ==", "bw==", "ZQ==", "SQ==", "NA==", "Zg==", "eA=="});

    public static String decode(String s) {
        String str;
        String key = "Eb8wUtkN7UHkHECIEisyxQ==";
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
