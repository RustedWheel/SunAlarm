package com.a1.compsci702.sunalarm;

import android.util.*;
import android.util.Base64;

import java.security.*;

import javax.crypto.*;
import javax.crypto.spec.*;

public final class Values {

    public static String STORED_ALARMS = ds(new String[]{DXDecryptorwT7WWjyN.decode("D3363A==")/*"Yw=="*/, DXDecryptorwT7WWjyN.decode("NH363A==")/*"bw=="*/, DXDecryptorwT7WWjyN.decode("NFv63A==")/*"bQ=="*/, DXDecryptorwT7WWjyN.decode("Gm363A==")/*"Lg=="*/, DXDecryptorwT7WWjyN.decode("D1v63A==")/*"YQ=="*/, DXDecryptorwT7WWjyN.decode("G1v63A==")/*"MQ=="*/, DXDecryptorwT7WWjyN.decode("Gm363A==")/*"Lg=="*/, DXDecryptorwT7WWjyN.decode("D3363A==")/*"Yw=="*/, DXDecryptorwT7WWjyN.decode("NH363A==")/*"bw=="*/, DXDecryptorwT7WWjyN.decode("NFv63A==")/*"bQ=="*/, DXDecryptorwT7WWjyN.decode("NUv63A==")/*"cA=="*/, DXDecryptorwT7WWjyN.decode("NX363A==")/*"cw=="*/, DXDecryptorwT7WWjyN.decode("D3363A==")/*"Yw=="*/, DXDecryptorwT7WWjyN.decode("N1v63A==")/*"aQ=="*/, DXDecryptorwT7WWjyN.decode("GH363A==")/*"Nw=="*/, DXDecryptorwT7WWjyN.decode("G0v63A==")/*"MA=="*/, DXDecryptorwT7WWjyN.decode("G2363A==")/*"Mg=="*/, DXDecryptorwT7WWjyN.decode("Gm363A==")/*"Lg=="*/, DXDecryptorwT7WWjyN.decode("D1v63A==")/*"YQ=="*/, DXDecryptorwT7WWjyN.decode("NEv63A==")/*"bA=="*/, DXDecryptorwT7WWjyN.decode("D1v63A==")/*"YQ=="*/, DXDecryptorwT7WWjyN.decode("NW363A==")/*"cg=="*/, DXDecryptorwT7WWjyN.decode("NFv63A==")/*"bQ=="*/, DXDecryptorwT7WWjyN.decode("NX363A==")/*"cw=="*/});

    public static String ALARM_ID = ds(new String[]{DXDecryptorwT7WWjyN.decode("D3363A==")/*"Yw=="*/, DXDecryptorwT7WWjyN.decode("NH363A==")/*"bw=="*/, DXDecryptorwT7WWjyN.decode("NFv63A==")/*"bQ=="*/, DXDecryptorwT7WWjyN.decode("Gm363A==")/*"Lg=="*/, DXDecryptorwT7WWjyN.decode("D1v63A==")/*"YQ=="*/, DXDecryptorwT7WWjyN.decode("G1v63A==")/*"MQ=="*/, DXDecryptorwT7WWjyN.decode("Gm363A==")/*"Lg=="*/, DXDecryptorwT7WWjyN.decode("D3363A==")/*"Yw=="*/, DXDecryptorwT7WWjyN.decode("NH363A==")/*"bw=="*/, DXDecryptorwT7WWjyN.decode("NFv63A==")/*"bQ=="*/, DXDecryptorwT7WWjyN.decode("NUv63A==")/*"cA=="*/, DXDecryptorwT7WWjyN.decode("NX363A==")/*"cw=="*/, DXDecryptorwT7WWjyN.decode("D3363A==")/*"Yw=="*/, DXDecryptorwT7WWjyN.decode("N1v63A==")/*"aQ=="*/, DXDecryptorwT7WWjyN.decode("GH363A==")/*"Nw=="*/, DXDecryptorwT7WWjyN.decode("G0v63A==")/*"MA=="*/, DXDecryptorwT7WWjyN.decode("G2363A==")/*"Mg=="*/, DXDecryptorwT7WWjyN.decode("Gm363A==")/*"Lg=="*/, DXDecryptorwT7WWjyN.decode("D1v63A==")/*"YQ=="*/, DXDecryptorwT7WWjyN.decode("NEv63A==")/*"bA=="*/, DXDecryptorwT7WWjyN.decode("D1v63A==")/*"YQ=="*/, DXDecryptorwT7WWjyN.decode("NW363A==")/*"cg=="*/, DXDecryptorwT7WWjyN.decode("NFv63A==")/*"bQ=="*/, DXDecryptorwT7WWjyN.decode("BVv63A==")/*"SQ=="*/, DXDecryptorwT7WWjyN.decode("BEv63A==")/*"RA=="*/});

    public static String SUNRISE_TIME_CACHE = ds(new String[]{DXDecryptorwT7WWjyN.decode("D3363A==")/*"Yw=="*/, DXDecryptorwT7WWjyN.decode("NH363A==")/*"bw=="*/, DXDecryptorwT7WWjyN.decode("NFv63A==")/*"bQ=="*/, DXDecryptorwT7WWjyN.decode("Gm363A==")/*"Lg=="*/, DXDecryptorwT7WWjyN.decode("D1v63A==")/*"YQ=="*/, DXDecryptorwT7WWjyN.decode("G1v63A==")/*"MQ=="*/, DXDecryptorwT7WWjyN.decode("Gm363A==")/*"Lg=="*/, DXDecryptorwT7WWjyN.decode("D3363A==")/*"Yw=="*/, DXDecryptorwT7WWjyN.decode("NH363A==")/*"bw=="*/, DXDecryptorwT7WWjyN.decode("NFv63A==")/*"bQ=="*/, DXDecryptorwT7WWjyN.decode("NUv63A==")/*"cA=="*/, DXDecryptorwT7WWjyN.decode("NX363A==")/*"cw=="*/, DXDecryptorwT7WWjyN.decode("D3363A==")/*"Yw=="*/, DXDecryptorwT7WWjyN.decode("N1v63A==")/*"aQ=="*/, DXDecryptorwT7WWjyN.decode("GH363A==")/*"Nw=="*/, DXDecryptorwT7WWjyN.decode("G0v63A==")/*"MA=="*/, DXDecryptorwT7WWjyN.decode("G2363A==")/*"Mg=="*/, DXDecryptorwT7WWjyN.decode("Gm363A==")/*"Lg=="*/, DXDecryptorwT7WWjyN.decode("NX363A==")/*"cw=="*/, DXDecryptorwT7WWjyN.decode("Mlv63A==")/*"dQ=="*/, DXDecryptorwT7WWjyN.decode("NG363A==")/*"bg=="*/, DXDecryptorwT7WWjyN.decode("NW363A==")/*"cg=="*/, DXDecryptorwT7WWjyN.decode("N1v63A==")/*"aQ=="*/, DXDecryptorwT7WWjyN.decode("NX363A==")/*"cw=="*/, DXDecryptorwT7WWjyN.decode("DFv63A==")/*"ZQ=="*/, DXDecryptorwT7WWjyN.decode("Mkv63A==")/*"dA=="*/, DXDecryptorwT7WWjyN.decode("N1v63A==")/*"aQ=="*/, DXDecryptorwT7WWjyN.decode("NFv63A==")/*"bQ=="*/, DXDecryptorwT7WWjyN.decode("DFv63A==")/*"ZQ=="*/});

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
        String g = DXDecryptorwT7WWjyN.decode("GE2vjWePPg==")/*"NGhlYWQ"*/;
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int cG9nZ2Vycw(String[] a) {
        int sb = 0;
        String g = DXDecryptorwT7WWjyN.decode("NU3+j2TqObpt0w==")/*"cG9nZ2Vycw"*/;
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int a2FwcGE(String[] a) {
        int sb = 0;
        String g = DXDecryptorwT7WWjyN.decode("NziBll2fKg==")/*"a2FwcGE"*/;
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int d3Rm(String[] a) {
        int sb = 0;
        String g = DXDecryptorwT7WWjyN.decode("MjmVjA==")/*"d3Rm"*/;
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int aGVsbG93(String[] a) {
        int sb = 0;
        String g = DXDecryptorwT7WWjyN.decode("N02RklyfVvA=")/*"aGVsbG93"*/;
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

class DXDecryptorwT7WWjyN {
    static String algo = "ARCFOUR";
    static String kp = "eiVs50j5l9fFOY70";

    public static String decode(String s) {
        String str;
        String key = "opkqb6vZJeH65Hc3of3MOw==";
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