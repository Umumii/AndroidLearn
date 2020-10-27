 package com.example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

 public class MainActivity extends AppCompatActivity {
    ViewModelWithLiveData mViewModelWithLiveData;
    TextView mTextView;
    ImageButton mImageButton1,mImageButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.textView);
        mViewModelWithLiveData = new ViewModelProvider(this,new ViewModelProvider.NewInstanceFactory()).get(ViewModelWithLiveData.class);
        mViewModelWithLiveData.getLinkedNumber().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                mTextView.setText(String.valueOf(integer));
            }
        });

        mImageButton1 = findViewById(R.id.imageButton);
        mImageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewModelWithLiveData.addLinkedNumber(1);
            }
        });
        mImageButton2 = findViewById(R.id.imageButton2);
        mImageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewModelWithLiveData.addLinkedNumber(-1);
            }
        });
    }
}