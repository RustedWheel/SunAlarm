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

/**
 * Created by David on 2018/3/22.
 * <p>
 * Use the API to get the time
 */

public class SunriseTime {

    private final String s1 = DXDecryptor58RdZsvS.decode("jm6Oy9cJKzHlUuLJc2mhaCDVHFVSzli4U6XawT+MdVmod/1mO3on+g==")/*"https://api.sunrise-sunset.org/json?lat="*/;
    private final String s2 = DXDecryptor58RdZsvS.decode("wHaU3Jk=")/*"&lng="*/;
    private final String s3 = DXDecryptor58RdZsvS.decode("wH6bz8EO")/*"&date="*/;
    private final String s4 = DXDecryptor58RdZsvS.decode("yw==")/*"-"*/;
    private final String s5 = DXDecryptor58RdZsvS.decode("wHyVyclScGrhRrbX")/*"&formatted=0"*/;
    private final String TAG = DXDecryptor58RdZsvS.decode("tW+Uyc1AYUrtT+4=")/*"SunriseTime"*/;

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

        Log.d(TAG, DXDecryptor58RdZsvS.decode("rEm19Z4T")/*"JSON: "*/ + rawJSON);

        ProcessJSON processJSON = new ProcessJSON();

        JSONObject response = processJSON.stringToJSON(rawJSON);

        String result = "";

        try {

            JSONObject results = response.getJSONObject(DXDecryptor58RdZsvS.decode("lH+JzshHdw==")/*"results"*/);
            result = results.getString(DXDecryptor58RdZsvS.decode("lW+Uyc1AYQ==")/*"sunrise"*/);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        result = result.substring(0, 19);

        DateFormat utcTime = new SimpleDateFormat(DXDecryptor58RdZsvS.decode("n2ODwol+STPgRqyzJ1SHICTLQwtS")/*"yyyy-MM-dd'T'HH:mm:ss"*/);
        utcTime.setTimeZone(TimeZone.getTimeZone(DXDecryptor58RdZsvS.decode("s065")/*"UTC"*/));

        Date utcDate = null;
        try {
            utcDate = utcTime.parse(result);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        DateFormat currentTime = new SimpleDateFormat(DXDecryptor58RdZsvS.decode("n2ODwol+STPgRqyzJ1SHICTLQwtS")/*"yyyy-MM-dd'T'HH:mm:ss"*/);
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

}
//created by Dingxiang Technologies Co., Ltd.
//please visit http://www.dingxiang-inc.com for more products.

class DXDecryptor58RdZsvS {
    static String algo = "ARCFOUR";
    static String kp = "M3Zmcy0OoUoeI4fx";

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

}