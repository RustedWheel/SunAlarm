package com.a1.compsci702.sunalarm;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import android.location.Location;
import android.os.AsyncTask;

import java.util.Calendar;
import java.util.Date;

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

    public SunriseTime() {

    }

    public Date getMockSunriseTime() {
        // DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        cal.set(2018, Calendar.APRIL, 9, 10, 11, 12); //Year, month, day of month, hours, minutes and seconds
        Date date = cal.getTime();

        return date;
    }

    public String getSunriseTime(Location location, Date date) throws IOException {
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

        return rawJSON;
    }

}
