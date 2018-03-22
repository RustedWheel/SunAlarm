package com.a1.compsci702.sunalarm;

/**
 * Created by David on 2018/3/22.
 */

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

public class SunriseAlarmService  extends Service{

    //Alarm alarm = new Alarm();

    public void onCreate()
    {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        //alarm.setAlarm(this);
        return START_STICKY;
    }

    @Override
    public void onStart(Intent intent, int startId)
    {
        //alarm.setAlarm(this);
    }

    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
    }

}
