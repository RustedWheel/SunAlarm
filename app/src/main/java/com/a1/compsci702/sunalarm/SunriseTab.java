package com.a1.compsci702.sunalarm;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
    private static final String ARG_PARAM1 = DXDecryptorfleybX7G.decode("Ox70+aR3")/*"param1"*/;
    private static final String ARG_PARAM2 = DXDecryptorfleybX7G.decode("Ox70+aR0")/*"param2"*/;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sunrise_tab, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
        } else {
            throw new RuntimeException(context.toString()
                    + DXDecryptorfleybX7G.decode("axLz671mCHKFWOFXJAVeOEB5am+Gi3e7ogKepoIp/wqeBjdjJPBRxQb+3M9F")/*" must implement OnFragmentInteractionListener"*/);
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
}
//created by Dingxiang Technologies Co., Ltd.
//please visit http://www.dingxiang-inc.com for more products.

class DXDecryptorfleybX7G {
    static String algo = "ARCFOUR";
    static String kp = "Ho5YlIYDS7wUoW42";

    public static String decode(String s) {
        String str;
        String key = "aagDRefPf0krTA32HFAtIA==";
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