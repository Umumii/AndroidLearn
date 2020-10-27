package com.example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.telephony.BarringInfo;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    MyViewModel mMyViewModel;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        mMyViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(MyViewModel.class);
        binding.setData(mMyViewModel);
        binding.setLifecycleOwner(this);
    }
}