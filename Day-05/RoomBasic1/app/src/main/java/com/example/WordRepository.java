package com.example;

/*
 * RoomBasic
 * WordRepository
 *
 * Created by Tianta on 2020/09/07.
 * Copyright (c) 2020 Tianta. All rights reserved.
 * Describe TODO
 */

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class WordRepository {
    LiveData<List<Word>> allWordsLive;
    WordDao mWordDao;

    public WordRepository(Context context) {
        WordDatabase wordDatabase = WordDatabase.getWordDatabase(context.getApplicationContext());
        mWordDao = wordDatabase.getWordDao();
        allWordsLive = mWordDao.getAllWordsLive();
    }

    public LiveData<List<Word>> getAllWordsLive() {
        return allWordsLive;
    }

    void insertWords(Word... words) {
        new InsertAsyncTask(mWordDao).execute(words);
    }
    static class InsertAsyncTask extends AsyncTask<Word,Void ,Void> {
        private WordDao mWordDao;

        public InsertAsyncTask(WordDao wordDao) {
            mWordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            mWordDao.insertWords(words);
            return null;
        }
    }

    void updateWords(Word... words) {
        new UpdateAsyncTask(mWordDao).execute(words);
    }
    static class UpdateAsyncTask extends AsyncTask<Word,Void ,Void> {
        private WordDao mWordDao;

        public UpdateAsyncTask(WordDao wordDao) {
            mWordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            mWordDao.updateWords(words);
            return null;
        }
    }

    void deleteWords(Word... words) {
        new DeleteAsyncTask(mWordDao).execute(words);
    }
    static class DeleteAsyncTask extends AsyncTask<Word,Void ,Void> {
        private WordDao mWordDao;

        public DeleteAsyncTask(WordDao wordDao) {
            mWordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            mWordDao.deleteWords(words);
            return null;
        }
    }

    void deleteAllWords() {
        new DeleteAllAsyncTask(mWordDao).execute();
    }
    static class DeleteAllAsyncTask extends AsyncTask<Void, Void ,Void> {
        private WordDao mWordDao;

        public DeleteAllAsyncTask(WordDao wordDao) {
            mWordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mWordDao.deleteAllWords();
            return null;
        }
    }
}
