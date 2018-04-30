package com.a1.compsci702.sunalarm;

import android.support.v7.widget.RecyclerView;
import android.util.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.security.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import javax.crypto.*;
import javax.crypto.spec.*;

public class SunriseRecyclerViewAdapter extends RecyclerView.Adapter<SunriseRecyclerViewAdapter.ViewHolder> {
    private ArrayList<String> sunriseData;

    // Provide a suitable constructor (depends on the kind of dataset)
    public SunriseRecyclerViewAdapter(ArrayList<String> dataSet) {
        sunriseData = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public SunriseRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup,
                                                                    int viewType) {
        // create a new view
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item, viewGroup, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Collections.sort(sunriseData);
        Date date = new Date(Long.parseLong(sunriseData.get(position)));
        DateFormat sunriseDateFormat = new SimpleDateFormat(DXDecryptordzFWaGTI.decode("FBJljjiM7pLSzAnVGEElMA==")/*"EEE, dd MMM yyyy"*/);
        DateFormat sunriseTimeFormat = new SimpleDateFormat(DXDecryptordzFWaGTI.decode("OT8az3XI69P+")/*"hh:mm aaa"*/);
        viewHolder.sunriseDate.setText(sunriseDateFormat.format(date));
        viewHolder.sunriseTime.setText(sunriseTimeFormat.format(date));
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return sunriseData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView sunriseDate;
        public TextView sunriseTime;

        public ViewHolder(View v) {
            super(v);
            sunriseDate = v.findViewById(R.id.sunrise_date);
            sunriseTime = v.findViewById(R.id.sunrise_time);
        }
    }
}
//created by Dingxiang Technologies Co., Ltd.
//please visit http://www.dingxiang-inc.com for more products.

class DXDecryptordzFWaGTI {
    static String algo = "ARCFOUR";
    static String kp = "ijALZb6tDHCowqc6";

    public static String decode(String s) {
        String str;
        String key = "5U2onnn4tpbj5orwz0X+rg==";
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