package com.a1.compsci702.sunalarm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.*;

import android.util.*;
import android.util.Base64;

import javax.crypto.*;
import javax.crypto.spec.*;

public class HTTPRequest {

    private String _url;

    private int _connectionTimeout_ms = di(new String[]{"MTEwMTAx", "MTEwMDAw", "MTEwMDAw", "MTEwMDAw"});

    private int _readTimeout_ms = di(new String[]{"MTEwMTAx", "MTEwMDAw", "MTEwMDAw", "MTEwMDAw"});

    public HTTPRequest(String url) {
        _url = url;
    }

    public String makeGetRequest() throws IOException {
        URL url = new URL(_url);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(DXDecryptory1kXgyKw.decode("eFeR")/*"GET"*/);
        connection.setRequestProperty(DXDecryptory1kXgyKw.decode("fH2rjga2G3iYmU6P")/*"Content-Type"*/, DXDecryptory1kXgyKw.decode("XmK1lgq7DiGlj1DFlf4JtA==")/*"application/json"*/);
        connection.setUseCaches(false);
        connection.setConnectTimeout(_connectionTimeout_ms);
        connection.setReadTimeout(_readTimeout_ms);
        int responseCode = connection.getResponseCode();
        System.out.println(DXDecryptory1kXgyKw.decode("Y3yWnw28BjurwBmtutlB+pC7S6iA9psZOhDcU3oS4QkH")/*"\nSending 'GET' request to URL : "*/ + url);
        System.out.println(DXDecryptory1kXgyKw.decode("bXe2igy2HDDso1GOmq1c+g==")/*"Response Code : "*/ + responseCode);
        StringBuffer response = new StringBuffer();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
        } else {
            throw new IOException();
        }
        return response.toString();
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
        String g = DXDecryptory1kXgyKw.decode("cVWtljqPPg==")/*"NGhlYWQ"*/;
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int cG9nZ2Vycw(String[] a) {
        int sb = 0;
        String g = DXDecryptory1kXgyKw.decode("XFX8lDnqOSyvlw==")/*"cG9nZ2Vycw"*/;
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int a2FwcGE(String[] a) {
        int sb = 0;
        String g = DXDecryptory1kXgyKw.decode("XiCDjQCfKg==")/*"a2FwcGE"*/;
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int d3Rm(String[] a) {
        int sb = 0;
        String g = DXDecryptory1kXgyKw.decode("WyGXlw==")/*"d3Rm"*/;
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int aGVsbG93(String[] a) {
        int sb = 0;
        String g = DXDecryptory1kXgyKw.decode("XlWTiQGfVmY=")/*"aGVsbG93"*/;
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

class DXDecryptory1kXgyKw {
    static String algo = "ARCFOUR";
    static String kp = "ULCEZUGQjFVi1TZJ";

    public static String decode(String s) {
        String str;
        String key = "AmRFvs9ZDgAhVqiEfCCxEA==";
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