package com.example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    WordDatabase mWordDatabase;
    WordDao mWordDao;
    TextView mTextView;
    Button insertButton,delteButton,updateButton,cleanButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWordDatabase = Room.databaseBuilder(this,WordDatabase.class,"word_database")
                .allowMainThreadQueries()
                .build();
        mWordDao = mWordDatabase.getWordDao();

        mTextView = findViewById(R.id.textView);
        updateView();

        insertButton =findViewById(R.id.buttonInsert);
        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Word word1 = new Word("hello","你好");
                Word word2 = new Word("world","世界");
                Word word3 = new Word("apple","苹果");
                mWordDao.insertWords(word1,word2,word3);
                updateView();
            }
        });

        cleanButton = findViewById(R.id.buttonClean);
        cleanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mWordDao.deleteAllWords();
                updateView();
            }
        });

        updateButton = findViewById(R.id.buttonUpdate);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mWordDao.updateWords(null);
                Word word = new Word("Hi","你好啊");
                word.setId(37);
                mWordDao.updateWords(word);
                updateView();
            }
        });

        delteButton = findViewById(R.id.buttonDelete);
        delteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Word word = new Word("Hi","你好啊");
                word.setId(39);
                mWordDao.deleteWords(word);
                updateView();
            }
        });
    }


    void updateView() {
        List<Word> list = mWordDao.getAllWords();
        String text = "";
        for (int i = 0;i < list.size();i++) {
            Word word = list.get(i);
            text += word.getId() + ":" + word.getWord() + "=" + word.getChineseMeaning() + "\n";
        }
        mTextView.setText(text);
    }
}