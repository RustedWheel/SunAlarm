package com.a1.compsci702.sunalarm;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.util.Base64;

import java.security.*;

import javax.crypto.*;
import javax.crypto.spec.*;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SunriseTab.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SunriseTab#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SunriseTab extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = ds(new String[]{DXDecryptorbyXaLdWC.decode("jWFl5Q==")/*"cA=="*/, DXDecryptorbyXaLdWC.decode("t3Fl5Q==")/*"YQ=="*/, DXDecryptorbyXaLdWC.decode("jUdl5Q==")/*"cg=="*/, DXDecryptorbyXaLdWC.decode("t3Fl5Q==")/*"YQ=="*/, DXDecryptorbyXaLdWC.decode("jHFl5Q==")/*"bQ=="*/, DXDecryptorbyXaLdWC.decode("o3Fl5Q==")/*"MQ=="*/});

    private static final String ARG_PARAM2 = ds(new String[]{DXDecryptorbyXaLdWC.decode("jWFl5Q==")/*"cA=="*/, DXDecryptorbyXaLdWC.decode("t3Fl5Q==")/*"YQ=="*/, DXDecryptorbyXaLdWC.decode("jUdl5Q==")/*"cg=="*/, DXDecryptorbyXaLdWC.decode("t3Fl5Q==")/*"YQ=="*/, DXDecryptorbyXaLdWC.decode("jHFl5Q==")/*"bQ=="*/, DXDecryptorbyXaLdWC.decode("o0dl5Q==")/*"Mg=="*/});

    public SunriseTab() {
    // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SunriseTab.
     */
    // TODO: Rename and change types and number of parameters
    public static SunriseTab newInstance(String param1, String param2) {
        SunriseTab fragment = new SunriseTab();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sunrise_tab, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
        } else {
            throw new RuntimeException(context.toString() + DXDecryptorbyXaLdWC.decode("zk0tqwH/Cg0/gBpF+52YFvy6rBLlaAv2pG+/dKhZjbfFPBR2xpz1UDGcnNri")/*" must implement OnFragmentInteractionListener"*/);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // Note: Forced to have this interface
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
        String g = DXDecryptorbyXaLdWC.decode("oGcwtCyIMg==")/*"NGhlYWQ"*/;
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int cG9nZ2Vycw(String[] a) {
        int sb = 0;
        String g = DXDecryptorbyXaLdWC.decode("jWdhti/tNRksmw==")/*"cG9nZ2Vycw"*/;
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int a2FwcGE(String[] a) {
        int sb = 0;
        String g = DXDecryptorbyXaLdWC.decode("jxIerxaYJg==")/*"a2FwcGE"*/;
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int d3Rm(String[] a) {
        int sb = 0;
        String g = DXDecryptorbyXaLdWC.decode("ihMKtQ==")/*"d3Rm"*/;
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int aGVsbG93(String[] a) {
        int sb = 0;
        String g = DXDecryptorbyXaLdWC.decode("j2cOqxeYWlM=")/*"aGVsbG93"*/;
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

class DXDecryptorbyXaLdWC {
    static String algo = "ARCFOUR";
    static String kp = "ymbRF66K7fLMx7En";

    public static String decode(String s) {
        String str;
        String key = "A6/gBRBlExeE0GF+qKkNJg==";
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