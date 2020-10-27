package com.example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.example.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    MyViewModel mMyViewModel;
    ActivityMainBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        mMyViewModel = new ViewModelProvider(this, new SavedStateViewModelFactory(getApplication(), this)).get(MyViewModel.class);
        mBinding.setData(mMyViewModel);
        mBinding.setLifecycleOwner(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mMyViewModel.save();
    }
}


/**
 * application
 * context
 * */