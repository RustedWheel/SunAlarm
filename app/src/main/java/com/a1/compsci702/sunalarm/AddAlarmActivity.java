package com.a1.compsci702.sunalarm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class AddAlarmActivity extends AppCompatActivity {

    private final String TAG = "AddAlarmActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_alarm);
        Log.d(TAG, "public class AddAlarmActivity");
    }
}
