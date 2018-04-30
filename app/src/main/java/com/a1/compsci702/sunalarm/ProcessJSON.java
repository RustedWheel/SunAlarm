package com.a1.compsci702.sunalarm;

import android.util.*;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.*;

import javax.crypto.*;
import javax.crypto.spec.*;

/**
 * Created by st970 on 28/03/2018.
 */

public class ProcessJSON {

    public JSONObject stringToJSON(String rawJSON) {
        JSONObject response = null;
        try {
            response = new JSONObject(rawJSON);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return response;
    }

}
//created by Dingxiang Technologies Co., Ltd.
//please visit http://www.dingxiang-inc.com for more products.

class DXDecryptorBXbUek0j {
    static String algo = "ARCFOUR";
    static String kp = "csfg3y9lQCoed3vM";

    public static String decode(String s) {
        String str;
        String key = "60IyvdQb0Vn87hfpxotfag==";
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