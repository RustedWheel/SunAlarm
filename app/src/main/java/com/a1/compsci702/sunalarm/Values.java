package com.a1.compsci702.sunalarm;

import android.util.*;

import java.security.*;

import javax.crypto.*;
import javax.crypto.spec.*;

public final class Values {

    public static String STORED_ALARMS = DXDecryptorg7W6HBLP.decode("aTIo0XGor9VFxLzYZZE4VuAbp9cbSyK3")/*"com.a1.compsci702.alarms"*/;
    public static String ALARM_ID = DXDecryptorg7W6HBLP.decode("aTIo0XGor9VFxLzYZZE4VuAbp9cbSyKNRA==")/*"com.a1.compsci702.alarmID"*/;
    public static String SUNRISE_TIME_CACHE = DXDecryptorg7W6HBLP.decode("aTIo0XGor9VFxLzYZZE4VuAbtc4USya3ZYKwRKQ=")/*"com.a1.compsci702.sunrisetime"*/;

}
//created by Dingxiang Technologies Co., Ltd.
//please visit http://www.dingxiang-inc.com for more products.

class DXDecryptorg7W6HBLP {
    static String algo = "ARCFOUR";
    static String kp = "NV7hbNh09cn8OWdf";

    public static String decode(String s) {
        String str;
        String key = "UuZ4QSr/cJtR+aFTpS4aQQ==";
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