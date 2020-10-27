package com.example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuWrapperICS;
import androidx.lifecycle.Observer;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.view.InputDevice;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button insertButton,cleanButton;
    WordViewModel mViewModel;
    MyAdapter mMyAdapter1,mMyAdapter2;
    RecyclerView mRecyclerView;
    Switch mSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mMyAdapter1 = new MyAdapter(true);
        mMyAdapter2 = new MyAdapter(false);
        mRecyclerView.setAdapter(mMyAdapter1);
        mSwitch = findViewById(R.id.switch1);

        mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    mRecyclerView.setAdapter(mMyAdapter1);
                    mMyAdapter1.notifyDataSetChanged();
                }
                else {
                    mRecyclerView.setAdapter(mMyAdapter2);
                    mMyAdapter2.notifyDataSetChanged();
                }
            }
        });

        mViewModel = new ViewModelProvider(this,new SavedStateViewModelFactory(this.getApplication(),this)).get(WordViewModel.class);
        mViewModel.getAllWordsLive().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(List<Word> words) {
                mMyAdapter1.setAllWords(words);
                mMyAdapter2.setAllWords(words);
                mMyAdapter1.notifyDataSetChanged();
            }
        });



        insertButton =findViewById(R.id.buttonInsert);
        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] english = {"hello","world","Android","Google","Project","Apple","View","String","Integer","Value"};
                String[] chinese = {"你好","世界","安卓系统","谷歌","工程","苹果公司","视图","字符串","整形","值"};
                for (Integer i = 0; i < english.length;i++) {
                    Word word = new Word(english[i],chinese[i]);
                    mViewModel.insertWords(word);
                }
            }
        });

        cleanButton = findViewById(R.id.buttonClean);
        cleanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewModel.deleteAllWords();
            }
        });
    }
}