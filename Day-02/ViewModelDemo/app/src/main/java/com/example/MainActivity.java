package com.example;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {
    MyViewModel mMyViewModel;
    TextView mTextView;
    Button mButton1,mButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMyViewModel = new ViewModelProvider(this,new ViewModelProvider.NewInstanceFactory()).get(MyViewModel.class);
        mTextView = findViewById(R.id.textView);
        if (mMyViewModel.number > 0) {
            mTextView.setText(String.valueOf(mMyViewModel.number));
        }
        mButton1 = findViewById(R.id.button);
        mButton2 = findViewById(R.id.button2);
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMyViewModel.number++;
                mTextView.setText(String.valueOf(mMyViewModel.number));
            }
        });
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMyViewModel.number += 2;
                mTextView.setText(String.valueOf(mMyViewModel.number));
            }
        });

    }
}
/*  1. ViewModel
 *  2. LiveData
 *  3. Room
 * */