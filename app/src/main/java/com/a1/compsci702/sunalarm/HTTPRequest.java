package com.a1.compsci702.sunalarm;

import android.util.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.*;

import javax.crypto.*;
import javax.crypto.spec.*;

public class HTTPRequest {

    private String _url;
    private int _connectionTimeout_ms = 5000;
    private int _readTimeout_ms = 5000;

    public HTTPRequest(String url) {
        _url = url;
    }

    public String makeGetRequest() throws IOException {

        URL url = new URL(_url);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(DXDecryptor6Nes9zR3.decode("Kppi")/*"GET"*/);

        connection.setRequestProperty(DXDecryptor6Nes9zR3.decode("LrBY+0TfVJRWRqlr")/*"Content-Type"*/, DXDecryptor6Nes9zR3.decode("DK9G40jSQc1rULchrr6lpA==")/*"application/json"*/);
        connection.setUseCaches(false);
        connection.setConnectTimeout(_connectionTimeout_ms);
        connection.setReadTimeout(_readTimeout_ms);

        int responseCode = connection.getResponseCode();
        System.out.println(DXDecryptor6Nes9zR3.decode("MbFl6k/VSddlH/5JgZnt6mQnz4jNkuZggujThxXZzqN3")/*"\nSending 'GET' request to URL : "*/ + url);
        System.out.println(DXDecryptor6Nes9zR3.decode("P7pF/07fU9wifLZqoe3w6g==")/*"Response Code : "*/ + responseCode);

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

}
//created by Dingxiang Technologies Co., Ltd.
//please visit http://www.dingxiang-inc.com for more products.

class DXDecryptor6Nes9zR3 {
    static String algo = "ARCFOUR";
    static String kp = "6ArBknB3NT5sM8Xl";

    public static String decode(String s) {
        String str;
        String key = "gAbjJTnGoinq3ZVDLv2jXQ==";
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