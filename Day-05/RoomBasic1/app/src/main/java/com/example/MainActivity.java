package com.example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity {
    WordDatabase mWordDatabase;
    WordDao mWordDao;
    TextView mTextView;
    Button insertButton,deleteButton,updateButton,cleanButton;
    WordViewModel mViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewModel = new ViewModelProvider(this,new SavedStateViewModelFactory(this.getApplication(),this)).get(WordViewModel.class);
        mWordDatabase = Room.databaseBuilder(this,WordDatabase.class,"word_database")
                .allowMainThreadQueries()
                .build();
        mWordDao = mWordDatabase.getWordDao();

        mTextView = findViewById(R.id.textView);
        mViewModel.getAllWordsLive().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(List<Word> words) {
                StringBuilder text = new StringBuilder();
                for (int i = 0;i < words.size();i++) {
                    Word word = words.get(i);
                    text.append(word.getId()).append(":").append(word.getWord()).append("=").append(word.getChineseMeaning()).append("\n");
                }
                mTextView.setText(text.toString());
            }
        });

        insertButton =findViewById(R.id.buttonInsert);
        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Word word1 = new Word("hello","你好");
                Word word2 = new Word("world","世界");
                Word word3 = new Word("apple","苹果");
                mViewModel.insertWords(word1,word2,word3);
            }
        });

        cleanButton = findViewById(R.id.buttonClean);
        cleanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewModel.deleteAllWords();
            }
        });

        updateButton = findViewById(R.id.buttonUpdate);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mWordDao.updateWords(null);
                Word word = new Word("Hi","你好啊");
                word.setId(70);
                mViewModel.updateWords(word);
            }
        });

        deleteButton = findViewById(R.id.buttonDelete);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Word word = new Word("Hi","你好啊");
                word.setId(72);
                mViewModel.deleteWords(word);
            }
        });
    }
}