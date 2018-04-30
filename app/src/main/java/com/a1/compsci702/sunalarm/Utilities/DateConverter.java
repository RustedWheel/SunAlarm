package com.a1.compsci702.sunalarm.Utilities;

import java.security.*;
import java.util.Calendar;
import java.util.Date;

import android.util.*;
import android.util.Base64;

import javax.crypto.*;
import javax.crypto.spec.*;

public final class DateConverter {

    public static Calendar convertDateToCalendar(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c;
    }

    public static String dateToString(Date date) {
        return date.getYear() + DXDecryptor6lFExsqw.decode("BQ==")/*"0"*/ + date.getMonth() + DXDecryptor6lFExsqw.decode("BQ==")/*"0"*/ + date.getDate();
    }

    public static int di(String[] a) {
        StringBuilder sb = new StringBuilder();
        for (String s : a) {
            byte[] d = Base64.decode(s, Base64.DEFAULT);
            String n = new String(d);
            sb.append(Integer.parseInt(n, 2) - 48);
        }
        return Integer.parseInt(sb.toString());
    }

    public static String ds(String[] a) {
        StringBuilder sb = new StringBuilder();
        for (String s : a) {
            byte[] d = Base64.decode(s, Base64.DEFAULT);
            String n = new String(d);
            sb.append(n);
        }
        return sb.toString();
    }

    public static int NGhlYWQ(String[] a) {
        int sb = 0;
        String g = DXDecryptor6lFExsqw.decode("e06Eu0w6kA==")/*"NGhlYWQ"*/;
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int cG9nZ2Vycw(String[] a) {
        int sb = 0;
        String g = DXDecryptor6lFExsqw.decode("Vk7VuU9fl47CVw==")/*"cG9nZ2Vycw"*/;
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int a2FwcGE(String[] a) {
        int sb = 0;
        String g = DXDecryptor6lFExsqw.decode("VDuqoHYqhA==")/*"a2FwcGE"*/;
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int d3Rm(String[] a) {
        int sb = 0;
        String g = DXDecryptor6lFExsqw.decode("UTq+ug==")/*"d3Rm"*/;
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int aGVsbG93(String[] a) {
        int sb = 0;
        String g = DXDecryptor6lFExsqw.decode("VE66pHcq+MQ=")/*"aGVsbG93"*/;
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }
}
//created by Dingxiang Technologies Co., Ltd.
//please visit http://www.dingxiang-inc.com for more products.

class DXDecryptor6lFExsqw {
    static String algo = "ARCFOUR";
    static String kp = "1tWWwId7mJrEjh3g";

    public static String decode(String s) {
        String str;
        String key = "dTV9doHa1nhPxKz0v3uKhg==";
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