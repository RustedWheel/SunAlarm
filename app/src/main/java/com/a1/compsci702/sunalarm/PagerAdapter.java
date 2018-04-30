package com.a1.compsci702.sunalarm;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.a1.compsci702.sunalarm.Tabs.AlarmTab;

public class PagerAdapter extends FragmentStatePagerAdapter {
    private final int ALARM_TAB = 0;
    private final int SUNRISE_TAB = 1;
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        if (position == ALARM_TAB) {
            AlarmTab alarmTab = new AlarmTab();
            return alarmTab;
        } else if (position == SUNRISE_TAB) {
            SunriseTab sunriseTab = new SunriseTab();
            return sunriseTab;
        } else {
            return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
