package com.a1.compsci702.sunalarm;

import android.util.Base64;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public final class exp {

    public static String getEXP(int op) {
        String code = null;
        switch(op) {
            case 223:
                code = "nUFeiiMMiW9Aq2LXnPQKUQ==";
                break;
            case 34:
                code = "pFUE54x6oiXUoU6pN6L2UA==";
                break;
            case 456:
                code = "bcAf5ddeFad0Ez0d";
                break;
            case 67:
                code = "akOepyFk3MX0XqppLLgBxQ==";
                break;
            case 98:
                code = "1L2c4klmqWuSexz98EmgLJfXUvlq6bL7KM4elTodqTE=";
                break;
            case 92:
                code = "CDUrMruS1AM85su+vIsb31gBN2vTyy6rYeYz84HuaDOONmvFY0o596rlh0XdG3Nd";
                break;
            case 134:
                code = "ANLydpE8NGKxmrF7+p2Cog==";
                break;
            case 87:
                code = "R4lS4XhH91NZEqOlGJct+Q==";
                break;
        }
        return code;
    }

    public static String dd(String d) {
        try {
            SecretKeySpec ss = new SecretKeySpec(getEXP(456).getBytes(), "AES");
            Cipher c = Cipher.getInstance("AES");
            c.init(Cipher.DECRYPT_MODE, ss);
            byte[] o = c.doFinal(Base64.decode(d.getBytes(), Base64.DEFAULT));
            return new String(o);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
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
        String g = "NGhlYWQ";
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int cG9nZ2Vycw(String[] a) {
        int sb = 0;
        String g = "cG9nZ2Vycw";
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int a2FwcGE(String[] a) {
        int sb = 0;
        String g = "a2FwcGE";
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int d3Rm(String[] a) {
        int sb = 0;
        String g = "d3Rm";
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int aGVsbG93(String[] a) {
        int sb = 0;
        String g = "aGVsbG93";
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }
}
