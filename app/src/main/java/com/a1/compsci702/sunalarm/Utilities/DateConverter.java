package com.a1.compsci702.sunalarm.Utilities;

import android.util.*;

import java.security.*;
import java.util.Calendar;
import java.util.Date;

import javax.crypto.*;
import javax.crypto.spec.*;

public final class DateConverter {

    public static Calendar convertDateToCalendar(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c;
    }

    public static String dateToString(Date date) {
        return date.getYear() + DXDecryptorYE6RiNIF.decode("/g==")/*"0"*/ + date.getMonth() + DXDecryptorYE6RiNIF.decode("/g==")/*"0"*/ + date.getDate();
    }
}
//created by Dingxiang Technologies Co., Ltd.
//please visit http://www.dingxiang-inc.com for more products.

class DXDecryptorYE6RiNIF {
    static String algo = "ARCFOUR";
    static String kp = "IhOlnh5Zhv1f8tPV";

    public static String decode(String s) {
        String str;
        String key = "fpUtZwIOu/CYw7V1vKVlxg==";
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