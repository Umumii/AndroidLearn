package com.example;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button mButton;
    TextView mTextView;
    boolean isLand = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = findViewById(R.id.button);
        mTextView = findViewById(R.id.textView);
        if (savedInstanceState != null) {
            String s = savedInstanceState.getString("key").toString();
            mTextView.setText(s);
        }
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isLand) {
                    isLand = false;
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                }
                else  {
                    isLand = true;
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                }
                mTextView.setText(mButton.getText().toString());
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("key",mTextView.getText().toString());
    }
}
/*
 *  1. 禁止屏幕翻转。设置screenOrientation为固定方向
 *  2. 翻转后重新布局。
 *  3. 翻转后保存数据。
 * */