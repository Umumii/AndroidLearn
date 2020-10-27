package com.example;

/*
 * DataBindingDemo
 * MyViewModel
 *
 * Created by Tianta on 2020/09/03.
 * Copyright (c) 2020 Tianta. All rights reserved.
 * Describe TODO
 */

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private MutableLiveData<Integer> number;

    public MutableLiveData<Integer> getNumber() {
        if (number ==null) {
            number = new MutableLiveData<>();
            number.setValue(0);
        }
        return number;
    }

    public void add() {
        number.setValue(number.getValue() + 1);
    }
}
