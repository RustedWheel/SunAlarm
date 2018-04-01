package com.a1.compsci702.sunalarm;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by David on 2018/3/22.
 *
 * Use the API to get the time
 */

public class SunriseTime {



    public SunriseTime(){

    }

    public Date getSunriseTime(){
        // DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        cal.set(2018, Calendar.APRIL, 9, 10, 11, 12); //Year, month, day of month, hours, minutes and seconds
        Date date = cal.getTime();

        return date;
    }

}
