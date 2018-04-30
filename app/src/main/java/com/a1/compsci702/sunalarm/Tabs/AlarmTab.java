package com.a1.compsci702.sunalarm.Tabs;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.a1.compsci702.sunalarm.R;
import android.util.Base64;

import java.security.*;

import javax.crypto.*;
import javax.crypto.spec.*;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AlarmTab.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AlarmTab#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AlarmTab extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = ds(new String[]{DXDecryptor5elHd2Qu.decode("+MN4vw==")/*"cA=="*/, DXDecryptor5elHd2Qu.decode("wtN4vw==")/*"YQ=="*/, DXDecryptor5elHd2Qu.decode("+OV4vw==")/*"cg=="*/, DXDecryptor5elHd2Qu.decode("wtN4vw==")/*"YQ=="*/, DXDecryptor5elHd2Qu.decode("+dN4vw==")/*"bQ=="*/, DXDecryptor5elHd2Qu.decode("1tN4vw==")/*"MQ=="*/});

    private static final String ARG_PARAM2 = ds(new String[]{DXDecryptor5elHd2Qu.decode("+MN4vw==")/*"cA=="*/, DXDecryptor5elHd2Qu.decode("wtN4vw==")/*"YQ=="*/, DXDecryptor5elHd2Qu.decode("+OV4vw==")/*"cg=="*/, DXDecryptor5elHd2Qu.decode("wtN4vw==")/*"YQ=="*/, DXDecryptor5elHd2Qu.decode("+dN4vw==")/*"bQ=="*/, DXDecryptor5elHd2Qu.decode("1uV4vw==")/*"Mg=="*/});

    private OnFragmentInteractionListener mListener;

    public AlarmTab() {
    // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AlarmTab.
     */
    // TODO: Rename and change types and number of parameters
    public static AlarmTab newInstance(String param1, String param2) {
        AlarmTab fragment = new AlarmTab();
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
        return inflater.inflate(R.layout.fragment_alarm_tab, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() + DXDecryptor5elHd2Qu.decode("u+8w8dwZKj54QczQs0PsN+5GWIvbGUjzkNF9tQ2ZBZnYcpOd07ER73j6HD4w")/*" must implement OnFragmentInteractionListener"*/);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
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

        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
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
        String g = DXDecryptor5elHd2Qu.decode("1cUt7vFuEg==")/*"NGhlYWQ"*/;
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int cG9nZ2Vycw(String[] a) {
        int sb = 0;
        String g = DXDecryptor5elHd2Qu.decode("+MV87PILFSprWg==")/*"cG9nZ2Vycw"*/;
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int a2FwcGE(String[] a) {
        int sb = 0;
        String g = DXDecryptor5elHd2Qu.decode("+rAD9ct+Bg==")/*"a2FwcGE"*/;
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int d3Rm(String[] a) {
        int sb = 0;
        String g = DXDecryptor5elHd2Qu.decode("/7EX7w==")/*"d3Rm"*/;
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int aGVsbG93(String[] a) {
        int sb = 0;
        String g = DXDecryptor5elHd2Qu.decode("+sUT8cp+emA=")/*"aGVsbG93"*/;
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

class DXDecryptor5elHd2Qu {
    static String algo = "ARCFOUR";
    static String kp = "pHicVKkmoc9w0ehN";

    public static String decode(String s) {
        String str;
        String key = "CLL2IEDr11GnPZKHrlgtQQ==";
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