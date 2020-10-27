package com.example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {
    MyChronometer mChronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mChronometer = findViewById(R.id.meter);
        getLifecycle().addObserver(mChronometer);
        // System.currentTimeMillis() unix 时间,单位毫秒,从1970-1-1 00.00.00 到当前时间的毫秒数,随时区的改变而改变.
        // SystemClock.elapsedRealtime()上次启动到现在所经过的毫秒数.


    }

}