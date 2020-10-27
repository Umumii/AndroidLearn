package com.example;

/*
 * SharedPreferences
 * MyViewModel
 *
 * Created by Tianta on 2020/09/04.
 * Copyright (c) 2020 Tianta. All rights reserved.
 * Describe
 */

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandle;

public class MyViewModel extends AndroidViewModel {
    SavedStateHandle mHandle;
    String mKey = getApplication().getResources().getString(R.string.dataKey);
    String shpName = getApplication().getResources().getString(R.string.shpName);

    public MyViewModel(@NonNull Application application, SavedStateHandle handle) {
        super(application);
        this.mHandle = handle;
        if (!handle.contains("")) {
            load();
        }
    }

    public LiveData<Integer> getNumber() {
        return mHandle.getLiveData(mKey);
    }

    public void load() {
        SharedPreferences shp = getApplication().getSharedPreferences(shpName, Context.MODE_PRIVATE);
        int x = shp.getInt(mKey, 0);
        mHandle.set(mKey, x);
    }

    public void save() {
        SharedPreferences shp = getApplication().getSharedPreferences(shpName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shp.edit();
        editor.putInt(mKey, getNumber().getValue() == null ? 0 : getNumber().getValue());
        editor.apply();
    }

    public void add(int x) {
        mHandle.set(mKey, (getNumber().getValue() == null ? 0 : getNumber().getValue()) + x);
    }
//    protected   本身以及子类可以调用使用
//    private     只有自己本身可以使用
//    public      全局都可使用
//                默认是在包里可见
}
