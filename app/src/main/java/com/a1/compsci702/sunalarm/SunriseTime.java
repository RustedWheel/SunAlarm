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

/**
 * Created by David on 2018/3/22.
 * <p>
 * Use the API to get the time
 */

public class SunriseTime {

    private final String s1 = "https://api.sunrise-sunset.org/json?lat=";
    private final String s2 = "&lng=";
    private final String s3 = "&date=";
    private final String s4 = "-";
    private final String s5 = "&formatted=0";
    private final String TAG = "SunriseTime";

    public SunriseTime() {

    }

    public Date getMockSunriseTime() {
        // DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        cal.set(2018, Calendar.APRIL, 9, 10, 11, 12); //Year, month, day of month, hours, minutes and seconds
        Date date = cal.getTime();

        return date;
    }

    public Date getSunriseTime(Location location, Date date) throws IOException {
        StringBuilder sb = new StringBuilder(s1);
        sb.append(location.getLatitude());
        sb.append(s2);
        sb.append(location.getLongitude());
        sb.append(s3);
        sb.append(date.getYear());
        sb.append(s4);
        sb.append(date.getMonth());
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

        result = result.substring(0,19);

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

        Log.e(TAG, s);

        return new Date();
    }

}
