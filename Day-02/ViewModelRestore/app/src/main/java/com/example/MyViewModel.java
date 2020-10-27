package com.example;

/*
 * ViewModelRestore
 * MyViewModel
 *
 * Created by Tianta on 2020/09/03.
 * Copyright (c) 2020 Tianta. All rights reserved.
 * Describe TODO
 */

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private SavedStateHandle mHandle;
    public MyViewModel(SavedStateHandle handle) {
        this.mHandle = handle;
    }

    public MutableLiveData<Integer> getNumber() {
        if (!mHandle.contains(MainActivity.KEY_NUMBWE)) {
            mHandle.set(MainActivity.KEY_NUMBWE,0);
        }
        return mHandle.getLiveData(MainActivity.KEY_NUMBWE);
    }

    public void add() {
        getNumber().setValue(getNumber().getValue() + 1);
    }
}