package com.a1.compsci702.sunalarm;

import android.location.Location;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import android.util.Base64;

public class SunriseTime {

    private final String s1 = ds(new String[]{"aA==", "dA==", "dA==", "cA==", "cw==", "Og==", "Lw==", "Lw==", "YQ==", "cA==", "aQ==", "Lg==", "cw==", "dQ==", "bg==", "cg==", "aQ==", "cw==", "ZQ==", "LQ==", "cw==", "dQ==", "bg==", "cw==", "ZQ==", "dA==", "Lg==", "bw==", "cg==", "Zw==", "Lw==", "ag==", "cw==", "bw==", "bg==", "Pw==", "bA==", "YQ==", "dA==", "PQ=="});

    private final String s2 = ds(new String[]{"Jg==", "bA==", "bg==", "Zw==", "PQ=="});

    private final String s3 = ds(new String[]{"Jg==", "ZA==", "YQ==", "dA==", "ZQ==", "PQ=="});

    private final String s4 = ds(new String[]{"LQ=="});

    private final String s5 = ds(new String[]{"Jg==", "Zg==", "bw==", "cg==", "bQ==", "YQ==", "dA==", "dA==", "ZQ==", "ZA==", "PQ==", "MA=="});

    private final String TAG = ds(new String[]{"Uw==", "dQ==", "bg==", "cg==", "aQ==", "cw==", "ZQ==", "VA==", "aQ==", "bQ==", "ZQ=="});

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
        Log.d(TAG, "JSON: " + rawJSON);
        ProcessJSON processJSON = new ProcessJSON();
        JSONObject response = processJSON.stringToJSON(rawJSON);
        String result = "";
        try {
            JSONObject results = response.getJSONObject("results");
            result = results.getString("sunrise");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        result = result.substring(0, 19);
        DateFormat utcTime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        utcTime.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date utcDate = null;
        try {
            utcDate = utcTime.parse(result);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DateFormat currentTime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
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
