package com.example.serializable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.MacAddress;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainActivity extends AppCompatActivity {
    EditText mNameEditText,mAgeEditText,mMathEditText,mEnglishEditText,mChineseEditText;
    TextView mTextView;
    Button mSaveButton,mLoadButton;
    private static final String FILE_NAME = "myFile.data";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUI();
        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int math = Integer.parseInt(mMathEditText.getText().toString());
                int english = Integer.parseInt(mEnglishEditText.getText().toString());
                int chinese = Integer.parseInt(mChineseEditText.getText().toString());
                Score score = new Score(math,chinese,english);
                String name = mNameEditText.getText().toString();
                int age = Integer.parseInt(mAgeEditText.getText().toString());
                Student student = new Student(name,age,score);
                try {
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(openFileOutput(FILE_NAME,MODE_PRIVATE));
                    objectOutputStream.writeObject(student);
                    objectOutputStream.flush();
                    objectOutputStream.close();
                    Toast.makeText(MainActivity.this,"Data saved!",Toast.LENGTH_SHORT).show();
                    mEnglishEditText.getText().clear();
                    mChineseEditText.getText().clear();
                    mMathEditText.getText().clear();
                    mNameEditText.getText().clear();
                    mAgeEditText.getText().clear();
                    mTextView.setText("-");
                } catch (IOException e) {
                    Log.e("myTag","onClick",e);
                }



            }
        });

        mLoadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    ObjectInputStream objectInputStream = new ObjectInputStream(openFileInput(FILE_NAME));
                    Student student = (Student) objectInputStream.readObject();
                    mNameEditText.setText(student.getName());
                    mAgeEditText.setText(String.valueOf(student.getAge()));
                    mMathEditText.setText(String.valueOf(student.getScore().getMath()));
                    mChineseEditText.setText(String.valueOf(student.getScore().getChinese()));
                    mEnglishEditText.setText(String.valueOf(student.getScore().getEnglish()));
                    mTextView.setText(student.getScore().getGrade());
                } catch (Exception e) {
                    Log.e("myTag","onClick",e);
                }

            }
        });

    }

    public void setupUI(){
        mNameEditText = findViewById(R.id.editTextName);
        mAgeEditText = findViewById(R.id.editTextAge);
        mMathEditText = findViewById(R.id.editTexMath);
        mEnglishEditText = findViewById(R.id.editTextEnglish);
        mChineseEditText = findViewById(R.id.editTextChinese);
        mTextView = findViewById(R.id.textView);
        mSaveButton = findViewById(R.id.buttonSave);
        mLoadButton = findViewById(R.id.buttonLoad);
    }
}