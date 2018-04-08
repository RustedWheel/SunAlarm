package com.a1.compsci702.sunalarm.Alarm;

import java.time.DayOfWeek;
import java.util.ArrayList;

public class RepeatInfo {

    private boolean _isRepeatOn;
    private ArrayList<DayOfWeek> _repeatWeekDays;

    public RepeatInfo(Boolean isRepeatOn, ArrayList<DayOfWeek> repeatWeekDays){
        _isRepeatOn = isRepeatOn;
        _repeatWeekDays = repeatWeekDays;
    }

    public void setRepeatWeekDays(ArrayList<DayOfWeek> repeatWeekDays){
        _repeatWeekDays = repeatWeekDays;
    }

    public ArrayList<DayOfWeek> getRepeatWeekDays(){
        return _repeatWeekDays;
    }

    public Boolean isRepeatOn(){
        return _isRepeatOn;
    }
}
