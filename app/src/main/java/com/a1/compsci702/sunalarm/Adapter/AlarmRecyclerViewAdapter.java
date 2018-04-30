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
import android.util.Base64;

import javax.crypto.*;
import javax.crypto.spec.*;

public class AlarmRecyclerViewAdapter extends RecyclerView.Adapter<AlarmRecyclerViewAdapter.ViewHolder> {

    private final String TAG = ds(new String[]{DXDecryptorROmGcpId.decode("td/tYA==")/*"QQ=="*/, DXDecryptorROmGcpId.decode("hs/tYA==")/*"bA=="*/, DXDecryptorROmGcpId.decode("vd/tYA==")/*"YQ=="*/, DXDecryptorROmGcpId.decode("h+ntYA==")/*"cg=="*/, DXDecryptorROmGcpId.decode("ht/tYA==")/*"bQ=="*/, DXDecryptorROmGcpId.decode("sentYA==")/*"Ug=="*/, DXDecryptorROmGcpId.decode("vt/tYA==")/*"ZQ=="*/, DXDecryptorROmGcpId.decode("vfntYA==")/*"Yw=="*/, DXDecryptorROmGcpId.decode("gd/tYA==")/*"eQ=="*/, DXDecryptorROmGcpId.decode("vfntYA==")/*"Yw=="*/, DXDecryptorROmGcpId.decode("hs/tYA==")/*"bA=="*/, DXDecryptorROmGcpId.decode("vt/tYA==")/*"ZQ=="*/, DXDecryptorROmGcpId.decode("h+ntYA==")/*"cg=="*/, DXDecryptorROmGcpId.decode("suntYA==")/*"Vg=="*/, DXDecryptorROmGcpId.decode("hd/tYA==")/*"aQ=="*/, DXDecryptorROmGcpId.decode("vt/tYA==")/*"ZQ=="*/, DXDecryptorROmGcpId.decode("gPntYA==")/*"dw=="*/});

    private ArrayList<Alarm> _alarms;

    private RecyclerViewClickListener _listener;

    public AlarmRecyclerViewAdapter(ArrayList<Alarm> alarms, RecyclerViewClickListener listener) {
        this._alarms = alarms;
        this._listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.alarm_list_row, parent, false);
        ViewHolder vh = new ViewHolder(v, _listener);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        DateFormat alarmDateFormat = new SimpleDateFormat(DXDecryptorROmGcpId.decode("ocuVcfyGdh/FOvdt+I6s9A==")/*"EEE, dd MMM yyyy"*/);
        DateFormat alarmTimeFormat = new SimpleDateFormat(DXDecryptorROmGcpId.decode("jObqMLHCc17p")/*"hh:mm aaa"*/);
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
        String g = DXDecryptorROmGcpId.decode("qsm4MYW1Qw==")/*"NGhlYWQ"*/;
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int cG9nZ2Vycw(String[] a) {
        int sb = 0;
        String g = DXDecryptorROmGcpId.decode("h8npM4bQREbrAA==")/*"cG9nZ2Vycw"*/;
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int a2FwcGE(String[] a) {
        int sb = 0;
        String g = DXDecryptorROmGcpId.decode("hbyWKr+lVw==")/*"a2FwcGE"*/;
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int d3Rm(String[] a) {
        int sb = 0;
        String g = DXDecryptorROmGcpId.decode("gL2CMA==")/*"d3Rm"*/;
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int aGVsbG93(String[] a) {
        int sb = 0;
        String g = DXDecryptorROmGcpId.decode("hcmGLr6lKww=")/*"aGVsbG93"*/;
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

class DXDecryptorROmGcpId {
    static String algo = "ARCFOUR";
    static String kp = "9f5epp64XUF1Mnke";

    public static String decode(String s) {
        String str;
        String key = "tXAFLW3R21+SuATPBF0kLQ==";
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