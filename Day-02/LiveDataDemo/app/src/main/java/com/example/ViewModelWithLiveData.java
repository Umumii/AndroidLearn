package com.example;

/*
 * LiveDataDemo
 * ViewModelWithLiveData
 *
 * Created by Tianta on 2020/09/03.
 * Copyright (c) 2020 Tianta. All rights reserved.
 * Describe TODO
 */

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ViewModelWithLiveData extends ViewModel {
    private MutableLiveData<Integer> LinkedNumber;

    public MutableLiveData<Integer> getLinkedNumber() {
        if (LinkedNumber == null) {
            LinkedNumber = new MutableLiveData<>();
            LinkedNumber.setValue(0);
        }
        return LinkedNumber;
    }

    public void addLinkedNumber(Integer n) {
        LinkedNumber.setValue(LinkedNumber.getValue() + n);
    }
}
