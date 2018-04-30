package com.a1.compsci702.sunalarm.Adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.a1.compsci702.sunalarm.Alarm.Alarm;
import com.a1.compsci702.sunalarm.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by st970 on 11/04/2018.
 */

public class AlarmRecyclerViewAdapter extends RecyclerView.Adapter<AlarmRecyclerViewAdapter.ViewHolder> {

    private ArrayList<Alarm> _alarms;
    private RecyclerViewClickListener _listener;

    private final String TAG = "AlarmRecyclerView";

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

    public AlarmRecyclerViewAdapter(ArrayList<Alarm> alarms, RecyclerViewClickListener listener) {
        Log.d(TAG, "alarms: " + alarms);
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
        DateFormat alarmDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy");
        DateFormat alarmTimeFormat = new SimpleDateFormat("hh:mm aaa");
        holder.alarmName.setText(_alarms.get(position).getName());
        holder.alarmDate.setText(alarmDateFormat.format(_alarms.get(position).getAlarmTime()));
        holder.alarmTime.setText(alarmTimeFormat.format(_alarms.get(position).getAlarmTime()));
    }

    @Override
    public int getItemCount() {
        return _alarms.size();
    }
}
