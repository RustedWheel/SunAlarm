package com.a1.compsci702.sunalarm.Utilities;

import java.util.Calendar;
import java.util.Date;

public final class DateConverter {

    public static Calendar convertDateToCalendar(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c;
    }

    public static String dateToString(Date date) {
        return date.getYear() + "-" + date.getMonth() + "-" + date.getDay();
    }
}
