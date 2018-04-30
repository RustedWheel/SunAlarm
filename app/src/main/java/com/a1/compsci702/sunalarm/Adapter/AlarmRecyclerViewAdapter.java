package com.a1.compsci702.sunalarm.Adapter;

import android.support.v7.widget.RecyclerView;
import android.util.*;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.a1.compsci702.sunalarm.Alarm.Alarm;
import com.a1.compsci702.sunalarm.R;

import java.security.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.crypto.*;
import javax.crypto.spec.*;

/**
 * Created by st970 on 11/04/2018.
 */

public class AlarmRecyclerViewAdapter extends RecyclerView.Adapter<AlarmRecyclerViewAdapter.ViewHolder> {

    private final String TAG = DXDecryptorxGKk99BC.decode("Caa8+P+cQzexxhMGH/Tvg7o=")/*"AlarmRecyclerView"*/;
    private ArrayList<Alarm> _alarms;
    private RecyclerViewClickListener _listener;

    public AlarmRecyclerViewAdapter(ArrayList<Alarm> alarms, RecyclerViewClickListener listener) {
        Log.d(TAG, DXDecryptorxGKk99BC.decode("Kaa8+P+9HHQ=")/*"alarms: "*/ + alarms);
        this._alarms = alarms;
        this._listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.alarm_list_row, parent, false);

        ViewHolder vh = new ViewHolder(v, _listener);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        DateFormat alarmDateFormat = new SimpleDateFormat(DXDecryptorxGKk99BC.decode("DY+YprKqQnSF6DJDFNv/nw==")/*"EEE, dd MMM yyyy"*/);
        DateFormat alarmTimeFormat = new SimpleDateFormat(DXDecryptorxGKk99BC.decode("IKLn5//uRzWp")/*"hh:mm aaa"*/);
        holder.alarmName.setText(_alarms.get(position).getName());
        holder.alarmDate.setText(alarmDateFormat.format(_alarms.get(position).getAlarmTime()));
        holder.alarmTime.setText(alarmTimeFormat.format(_alarms.get(position).getAlarmTime()));
    }

    @Override
    public int getItemCount() {
        return _alarms.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case
        public TextView alarmName;
        public TextView alarmTime;
        public TextView alarmDate;
        private RecyclerViewClickListener vHListener;

        public ViewHolder(View v, RecyclerViewClickListener listener) {
            super(v);
            v.setOnClickListener(this);
            alarmName = v.findViewById(R.id.alarm_name);
            alarmTime = v.findViewById(R.id.alarm_time);
            alarmDate = v.findViewById(R.id.alarm_date);
            vHListener = listener;
            alarmName.setOnClickListener(this);
            alarmTime.setOnClickListener(this);
            alarmDate.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            vHListener.onRowClick(view, getAdapterPosition());
        }
    }
}
//created by Dingxiang Technologies Co., Ltd.
//please visit http://www.dingxiang-inc.com for more products.

class DXDecryptorxGKk99BC {
    static String algo = "ARCFOUR";
    static String kp = "10w8seFUF6ZZ3AK0";

    public static String decode(String s) {
        String str;
        String key = "iglORwoOuofNNsI+BHR+Yw==";
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