package com.a1.compsci702.sunalarm.Alarm;

import com.a1.compsci702.sunalarm.Utilities.DayOfWeek;

import java.util.ArrayList;

public class RepeatInfo {

    private boolean _isRepeatOn;
    private ArrayList<DayOfWeek.Day> _repeatWeekDays;

    public RepeatInfo(Boolean isRepeatOn, ArrayList<DayOfWeek.Day> repeatWeekDays) {
        _isRepeatOn = isRepeatOn;
        _repeatWeekDays = repeatWeekDays;
    }

    public ArrayList<DayOfWeek.Day> getRepeatWeekDays() {
        return _repeatWeekDays;
    }

    public void setRepeatWeekDays(ArrayList<DayOfWeek.Day> repeatWeekDays) {
        _repeatWeekDays = repeatWeekDays;
    }

    public Boolean isRepeatOn() {
        return _isRepeatOn;
    }
}
