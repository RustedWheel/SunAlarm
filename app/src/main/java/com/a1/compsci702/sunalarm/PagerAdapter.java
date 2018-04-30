package com.a1.compsci702.sunalarm;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.*;

import com.a1.compsci702.sunalarm.Tabs.AlarmTab;

import java.security.*;

import javax.crypto.*;
import javax.crypto.spec.*;

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
//created by Dingxiang Technologies Co., Ltd.
//please visit http://www.dingxiang-inc.com for more products.

class DXDecryptorn4CdMdIO {
    static String algo = "ARCFOUR";
    static String kp = "QQamnxYPNlcPb8rP";

    public static String decode(String s) {
        String str;
        String key = "JGFFzy05XLI1ZHLRUVxflg==";
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