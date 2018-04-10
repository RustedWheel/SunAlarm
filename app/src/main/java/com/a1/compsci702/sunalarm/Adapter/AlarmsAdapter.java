package com.a1.compsci702.sunalarm.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.a1.compsci702.sunalarm.Alarm.Alarm;
import com.a1.compsci702.sunalarm.R;

import java.util.List;

/**
 * Created by st970 on 10/04/2018.
 */

public class AlarmsAdapter extends RecyclerView.Adapter<AlarmsAdapter.AlarmViewHolder> {

    private List<Alarm> _alarmList;

    public class AlarmViewHolder extends RecyclerView.ViewHolder {
        public TextView alarm_time, alarm_name, alarm_date;
        public AlarmViewHolder(View view) {
            super(view);
            alarm_time = view.findViewById(R.id.alarm_time);
            alarm_name = view.findViewById(R.id.alarm_name);
            alarm_date = view.findViewById(R.id.alarm_date);
        }
    }

    public AlarmsAdapter(List<Alarm> alarmList) {
        this._alarmList = alarmList;
    }

    @Override
    public AlarmViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.alarm_list_row, parent, false);
        return new AlarmViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AlarmViewHolder holder, int position) {
        Alarm alarm = _alarmList.get(position);
        holder.alarm_time.setText(alarm.getAlarmTime().toString());
        holder.alarm_name.setText(alarm.getName());
        holder.alarm_date.setText(alarm.getAlarmTime().toString());
    }

    @Override
    public int getItemCount() {
        return _alarmList.size();
    }
}
