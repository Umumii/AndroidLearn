package com.example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.example.databinding.ActivityMain2Binding;
import com.example.databinding.ActivityMainBinding;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ActivityMain2Binding binding = DataBindingUtil.setContentView(this,R.layout.activity_main2);
        Intent intent = getIntent();

//        MyApplication myApplication = (MyApplication)getApplication();
//        Student student = myApplication.mStudent;
        Bundle bundle = intent.getBundleExtra("data");
        Student student = bundle.getParcelable("student");
        binding.textViewName.setText(student.getName());
        binding.textViewAge.setText(String.valueOf(student.getAge()));
        binding.textViewMath.setText(String.valueOf(student.getScore().getMath()));
        binding.textViewChinese.setText(String.valueOf(student.getScore().getEnglish()));

    }
}