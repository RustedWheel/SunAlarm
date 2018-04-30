package com.a1.compsci702.sunalarm.Exceptions;

import android.util.*;

import java.security.*;

import javax.crypto.*;
import javax.crypto.spec.*;

/**
 * Created by David on 2018/3/29.
 */

public class NoConnectionException extends Exception {

    public NoConnectionException() {
    }

}
//created by Dingxiang Technologies Co., Ltd.
//please visit http://www.dingxiang-inc.com for more products.

class DXDecryptorgYRbmNi3 {
    static String algo = "ARCFOUR";
    static String kp = "cRjpITcRqzrTQ37F";

    public static String decode(String s) {
        String str;
        String key = "qB8U4b0d9PX1drCOrebAlA==";
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