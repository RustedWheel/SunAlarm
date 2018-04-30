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
import android.util.Base64;

public class AlarmRecyclerViewAdapter extends RecyclerView.Adapter<AlarmRecyclerViewAdapter.ViewHolder> {

    private final String TAG = DXDecryptorxGKk99BC.decode("Caa8+P+cQzexxhMGH/Tvg7o=");

    private ArrayList<Alarm> _alarms;

    private RecyclerViewClickListener _listener;

    public AlarmRecyclerViewAdapter(ArrayList<Alarm> alarms, RecyclerViewClickListener listener) {
        Log.d(TAG, DXDecryptorxGKk99BC.decode("Kaa8+P+9HHQ=") + /*"alarms: "*/
        alarms);
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
        DateFormat alarmDateFormat = new SimpleDateFormat(DXDecryptorxGKk99BC.decode("DY+YprKqQnSF6DJDFNv/nw=="));
        DateFormat alarmTimeFormat = new SimpleDateFormat(DXDecryptorxGKk99BC.decode("IKLn5//uRzWp"));
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
        String g = "NGhlYWQ";
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int cG9nZ2Vycw(String[] a) {
        int sb = 0;
        String g = "cG9nZ2Vycw";
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int a2FwcGE(String[] a) {
        int sb = 0;
        String g = "a2FwcGE";
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int d3Rm(String[] a) {
        int sb = 0;
        String g = "d3Rm";
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int aGVsbG93(String[] a) {
        int sb = 0;
        String g = "aGVsbG93";
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }
}

class DXDecryptorxGKk99BC {

    static String algo = ds(new String[]{"QQ==", "Ug==", "Qw==", "Rg==", "Tw==", "VQ==", "Ug=="});

    static String kp = ds(new String[]{"MQ==", "MA==", "dw==", "OA==", "cw==", "ZQ==", "Rg==", "VQ==", "Rg==", "Ng==", "Wg==", "Wg==", "Mw==", "QQ==", "Sw==", "MA=="});

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
        String g = "NGhlYWQ";
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int cG9nZ2Vycw(String[] a) {
        int sb = 0;
        String g = "cG9nZ2Vycw";
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int a2FwcGE(String[] a) {
        int sb = 0;
        String g = "a2FwcGE";
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int d3Rm(String[] a) {
        int sb = 0;
        String g = "d3Rm";
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }

    public static int aGVsbG93(String[] a) {
        int sb = 0;
        String g = "aGVsbG93";
        for (String s : a) {
            sb += s.length();
        }
        sb += g.length();
        sb += g.hashCode();
        return sb;
    }
}
