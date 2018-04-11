package com.a1.compsci702.sunalarm.Adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.a1.compsci702.sunalarm.Alarm.Alarm;
import com.a1.compsci702.sunalarm.R;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

/**
 * Created by st970 on 11/04/2018.
 */

public class AlarmRecyclerViewAdapter extends RecyclerView.Adapter<AlarmRecyclerViewAdapter.ViewHolder> {
    private ArrayList<Alarm> _alarms;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textView;

        public ViewHolder(TextView v) {
            super(v);

            textView = v;
        }
    }

    public AlarmRecyclerViewAdapter(ArrayList<Alarm> alarms) {
        Log.e(TAG, "public AlarmRecyclerViewAdapter() " + alarms);


        this._alarms = alarms;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView v = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(_alarms.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return _alarms.size();
    }
}
