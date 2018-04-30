package com.a1.compsci702.sunalarm.Alarm;

import android.util.*;

import java.security.*;

import javax.crypto.*;
import javax.crypto.spec.*;

public final class AlarmType {

    public enum type {
        sunrise, sunset
    }

}
//created by Dingxiang Technologies Co., Ltd.
//please visit http://www.dingxiang-inc.com for more products.

class DXDecryptorvKAYOZko {
    static String algo = "ARCFOUR";
    static String kp = "2uK3uQJb5lPk1WcJ";

    public static String decode(String s) {
        String str;
        String key = "PSd2GDK5Uf4SZ5xCH+bTwg==";
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