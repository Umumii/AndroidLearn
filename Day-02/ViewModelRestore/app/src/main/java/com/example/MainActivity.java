package com.example;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    MyViewModel mMyViewModel;
    ActivityMainBinding mBinding;

    public final static String KEY_NUMBWE = "my_number";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMyViewModel = new ViewModelProvider(this,new SavedStateViewModelFactory(getApplication(),this)).get(MyViewModel.class);
//        if (savedInstanceState != null) {
//            mMyViewModel.getNumber().setValue(savedInstanceState.getInt(KEY_NUMBWE));
//        }
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        mBinding.setData(mMyViewModel);
        mBinding.setLifecycleOwner(this);
    }

//    @Override
//    protected void onSaveInstanceState(@NonNull Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putInt(KEY_NUMBWE,mMyViewModel.getNumber().getValue());
//    }
}