package com.a1.compsci702.sunalarm;

import android.location.Location;
import android.util.*;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.security.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import android.util.Base64;

import javax.crypto.*;
import javax.crypto.spec.*;

public class SunriseTime {

    private final String s1 = ds(new String[]{DXDecryptore0udg8Cq.decode("KFTYCA==")/*"aA=="*/, DXDecryptore0udg8Cq.decode("LVTYCA==")/*"dA=="*/, DXDecryptore0udg8Cq.decode("LVTYCA==")/*"dA=="*/, DXDecryptore0udg8Cq.decode("KlTYCA==")/*"cA=="*/, DXDecryptore0udg8Cq.decode("KmLYCA==")/*"cw=="*/, DXDecryptore0udg8Cq.decode("BnLYCA==")/*"Og=="*/, DXDecryptore0udg8Cq.decode("BWLYCA==")/*"Lw=="*/, DXDecryptore0udg8Cq.decode("BWLYCA==")/*"Lw=="*/, DXDecryptore0udg8Cq.decode("EETYCA==")/*"YQ=="*/, DXDecryptore0udg8Cq.decode("KlTYCA==")/*"cA=="*/, DXDecryptore0udg8Cq.decode("KETYCA==")/*"aQ=="*/, DXDecryptore0udg8Cq.decode("BXLYCA==")/*"Lg=="*/, DXDecryptore0udg8Cq.decode("KmLYCA==")/*"cw=="*/, DXDecryptore0udg8Cq.decode("LUTYCA==")/*"dQ=="*/, DXDecryptore0udg8Cq.decode("K3LYCA==")/*"bg=="*/, DXDecryptore0udg8Cq.decode("KnLYCA==")/*"cg=="*/, DXDecryptore0udg8Cq.decode("KETYCA==")/*"aQ=="*/, DXDecryptore0udg8Cq.decode("KmLYCA==")/*"cw=="*/, DXDecryptore0udg8Cq.decode("E0TYCA==")/*"ZQ=="*/, DXDecryptore0udg8Cq.decode("BUTYCA==")/*"LQ=="*/, DXDecryptore0udg8Cq.decode("KmLYCA==")/*"cw=="*/, DXDecryptore0udg8Cq.decode("LUTYCA==")/*"dQ=="*/, DXDecryptore0udg8Cq.decode("K3LYCA==")/*"bg=="*/, DXDecryptore0udg8Cq.decode("KmLYCA==")/*"cw=="*/, DXDecryptore0udg8Cq.decode("E0TYCA==")/*"ZQ=="*/, DXDecryptore0udg8Cq.decode("LVTYCA==")/*"dA=="*/, DXDecryptore0udg8Cq.decode("BXLYCA==")/*"Lg=="*/, DXDecryptore0udg8Cq.decode("K2LYCA==")/*"bw=="*/, DXDecryptore0udg8Cq.decode("KnLYCA==")/*"cg=="*/, DXDecryptore0udg8Cq.decode("E2LYCA==")/*"Zw=="*/, DXDecryptore0udg8Cq.decode("BWLYCA==")/*"Lw=="*/, DXDecryptore0udg8Cq.decode("KHLYCA==")/*"ag=="*/, DXDecryptore0udg8Cq.decode("KmLYCA==")/*"cw=="*/, DXDecryptore0udg8Cq.decode("K2LYCA==")/*"bw=="*/, DXDecryptore0udg8Cq.decode("K3LYCA==")/*"bg=="*/, DXDecryptore0udg8Cq.decode("GWLYCA==")/*"Pw=="*/, DXDecryptore0udg8Cq.decode("K1TYCA==")/*"bA=="*/, DXDecryptore0udg8Cq.decode("EETYCA==")/*"YQ=="*/, DXDecryptore0udg8Cq.decode("LVTYCA==")/*"dA=="*/, DXDecryptore0udg8Cq.decode("GUTYCA==")/*"PQ=="*/});

    private final String s2 = ds(new String[]{DXDecryptore0udg8Cq.decode("A3LYCA==")/*"Jg=="*/, DXDecryptore0udg8Cq.decode("K1TYCA==")/*"bA=="*/, DXDecryptore0udg8Cq.decode("K3LYCA==")/*"bg=="*/, DXDecryptore0udg8Cq.decode("E2LYCA==")/*"Zw=="*/, DXDecryptore0udg8Cq.decode("GUTYCA==")/*"PQ=="*/});

    private final String s3 = ds(new String[]{DXDecryptore0udg8Cq.decode("A3LYCA==")/*"Jg=="*/, DXDecryptore0udg8Cq.decode("E1TYCA==")/*"ZA=="*/, DXDecryptore0udg8Cq.decode("EETYCA==")/*"YQ=="*/, DXDecryptore0udg8Cq.decode("LVTYCA==")/*"dA=="*/, DXDecryptore0udg8Cq.decode("E0TYCA==")/*"ZQ=="*/, DXDecryptore0udg8Cq.decode("GUTYCA==")/*"PQ=="*/});

    private final String s4 = ds(new String[]{DXDecryptore0udg8Cq.decode("BUTYCA==")/*"LQ=="*/});

    private final String s5 = ds(new String[]{DXDecryptore0udg8Cq.decode("A3LYCA==")/*"Jg=="*/, DXDecryptore0udg8Cq.decode("E3LYCA==")/*"Zg=="*/, DXDecryptore0udg8Cq.decode("K2LYCA==")/*"bw=="*/, DXDecryptore0udg8Cq.decode("KnLYCA==")/*"cg=="*/, DXDecryptore0udg8Cq.decode("K0TYCA==")/*"bQ=="*/, DXDecryptore0udg8Cq.decode("EETYCA==")/*"YQ=="*/, DXDecryptore0udg8Cq.decode("LVTYCA==")/*"dA=="*/, DXDecryptore0udg8Cq.decode("LVTYCA==")/*"dA=="*/, DXDecryptore0udg8Cq.decode("E0TYCA==")/*"ZQ=="*/, DXDecryptore0udg8Cq.decode("E1TYCA==")/*"ZA=="*/, DXDecryptore0udg8Cq.decode("GUTYCA==")/*"PQ=="*/, DXDecryptore0udg8Cq.decode("BFTYCA==")/*"MA=="*/});

    private final String TAG = ds(new String[]{DXDecryptore0udg8Cq.decode("HGLYCA==")/*"Uw=="*/, DXDecryptore0udg8Cq.decode("LUTYCA==")/*"dQ=="*/, DXDecryptore0udg8Cq.decode("K3LYCA==")/*"bg=="*/, DXDecryptore0udg8Cq.decode("KnLYCA==")/*"cg=="*/, DXDecryptore0udg8Cq.decode("KETYCA==")/*"aQ=="*/, DXDecryptore0udg8Cq.decode("KmLYCA==")/*"cw=="*/, DXDecryptore0udg8Cq.decode("E0TYCA==")/*"ZQ=="*/, DXDecryptore0udg8Cq.decode("H1TYCA==")/*"VA=="*/, DXDecryptore0udg8Cq.decode("KETYCA==")/*"aQ=="*/, DXDecryptore0udg8Cq.decode("K0TYCA==")/*"bQ=="*/, DXDecryptore0udg8Cq.decode("E0TYCA==")/*"ZQ=="*/});

    public SunriseTime() {
    }

    public Date getSunriseTime(Location location, Date date) throws IOException {
        StringBuilder sb = new StringBuilder(s1);
        sb.append(location.getLatitude());
        sb.append(s2);
        sb.append(location.getLongitude());
        sb.append(s3);
        sb.append(date.getYear() + 1900);
        sb.append(s4);
        sb.append(date.getMonth() + 1);
        sb.append(s4);
        sb.append(date.getDate());
        sb.append(s5);
        HTTPRequest request = new HTTPRequest(sb.toString());
        String rawJSON = request.makeGetRequest();
        ProcessJSON processJSON = new ProcessJSON();
        JSONObject response = processJSON.stringToJSON(rawJSON);
        String result = "";
        try {
            JSONObject results = response.getJSONObject(DXDecryptore0udg8Cq.decode("O3CWQNUbAQ==")/*"results"*/);
            result = results.getString(DXDecryptore0udg8Cq.decode("OmCLR9AcFw==")/*"sunrise"*/);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        result = result.substring(0, 19);
        DateFormat utcTime = new SimpleDateFormat(DXDecryptore0udg8Cq.decode("MGycTJQiP0NAcxI4EqprCnKo3mDQ")/*"yyyy-MM-dd'T'HH:mm:ss"*/);
        utcTime.setTimeZone(TimeZone.getTimeZone(DXDecryptore0udg8Cq.decode("HEGm")/*"UTC"*/));
        Date utcDate = null;
        try {
            utcDate = utcTime.parse(result);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DateFormat currentTime = new SimpleDateFormat(DXDecryptore0udg8Cq.decode("MGycTJQiP0NAcxI4EqprCnKo3mDQ")/*"yyyy-MM-dd'T'HH:mm:ss"*/);
        currentTime.setTimeZone(TimeZone.getDefault());
        String s = currentTime.format(utcDate);
        Date convertedDate = null;
        try {
            convertedDate = currentTime.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return convertedDate;
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
        String g = DXDecryptore0udg8Cq.decode("B1KNWeA4Iw==")/*"NGhlYWQ"*/;
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int cG9nZ2Vycw(String[] a) {
        int sb = 0;
        String g = DXDecryptore0udg8Cq.decode("KlLcW+NdJBdHYA==")/*"cG9nZ2Vycw"*/;
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int a2FwcGE(String[] a) {
        int sb = 0;
        String g = DXDecryptore0udg8Cq.decode("KCejQtooNw==")/*"a2FwcGE"*/;
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int d3Rm(String[] a) {
        int sb = 0;
        String g = DXDecryptore0udg8Cq.decode("LSa3WA==")/*"d3Rm"*/;
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int aGVsbG93(String[] a) {
        int sb = 0;
        String g = DXDecryptore0udg8Cq.decode("KFKzRtsoS10=")/*"aGVsbG93"*/;
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

class DXDecryptore0udg8Cq {
    static String algo = "ARCFOUR";
    static String kp = "K7rpFiPHq4kST4J0";

    public static String decode(String s) {
        String str;
        String key = "7xmB3p/DDiGhY7VC2r5RqA==";
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