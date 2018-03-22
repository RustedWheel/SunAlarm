package com.a1.compsci702.sunalarm;

import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout etTime;
    private AppCompatButton btnSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSet = (AppCompatButton) findViewById(R.id.setAlarm);
        etTime = (TextInputLayout) findViewById(R.id.time_input_layout);

        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String time = etTime.getEditText().getText().toString();

                // Placeholder, currently in seconds
                int seconds = Integer.parseInt(time);



            }
        });

    }
}
