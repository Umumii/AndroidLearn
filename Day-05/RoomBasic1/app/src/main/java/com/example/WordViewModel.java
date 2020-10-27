package com.example;

/*
 * RoomBasic
 * WordViewModel
 *
 * Created by Tana on 2020/09/07.
 * Copyright (c) 2020 Tana. All rights reserved.
 * Describe
 */

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class WordViewModel extends AndroidViewModel {
    WordRepository mWordRepository;

    public WordViewModel(@NonNull Application application) {
        super(application);
        mWordRepository = new WordRepository(application);
    }

    public LiveData<List<Word>> getAllWordsLive() {
        return mWordRepository.getAllWordsLive();
    }

    void insertWords(Word... words) {
        mWordRepository.insertWords(words);
    }

    void updateWords(Word... words) {
        mWordRepository.updateWords(words);
    }

    void deleteWords(Word... words) {
        mWordRepository.deleteWords(words);
    }

    void deleteAllWords() {
        mWordRepository.deleteAllWords();
    }
}
