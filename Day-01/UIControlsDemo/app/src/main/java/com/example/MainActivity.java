package com.example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView mTextView;
    Button mButton,mButton1,mButton3;
    Switch mSwitch;
    ProgressBar mProgressBar;
    EditText mEditText;
    RadioGroup mRadioGroup;
    ImageView mImageView;
    SeekBar mSeekBar;
    CheckBox mCheckBox1,mCheckBox2,mCheckBox3;
    RatingBar mRatingBar;

    String like = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.textView2);
        mButton = findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextView.setText(R.string.left);
            }
        });
        mButton1 = findViewById(R.id.button2);
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextView.setText(R.string.right);
            }
        });
        mButton3 = findViewById(R.id.button3);
        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = mEditText.getText().toString();
                if (TextUtils.isEmpty(s)) {
                    s = "0";
                }
                // todo
                mProgressBar.setProgress(Integer.valueOf(s), true);
            }
        });
        mSwitch = findViewById(R.id.switch2);
        mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    mTextView.setText("on");
                }
                else {
                    mTextView.setText("off");
                }
            }
        });
        mProgressBar = findViewById(R.id.progressBar2);

        mEditText = findViewById(R.id.editTextTextPersonName2);
        mImageView = findViewById(R.id.imageView3);
        mRadioGroup = findViewById(R.id.radioGroup1);
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.radioButton2) {
                    mImageView.setImageResource(R.mipmap.apple_logo);
                }
                else  {
                    mImageView.setImageResource(R.mipmap.android_logo);
                }
            }
        });
        mSeekBar = findViewById(R.id.seekBar);
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mTextView.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        mCheckBox1 = findViewById(R.id.checkBox);
        mCheckBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    like = "lolita";
                    toastWithMessage(like);
                }
                else {
                    like = "";
                }

            }
        });
        mCheckBox2 = findViewById(R.id.checkBox2);
        mCheckBox3 = findViewById(R.id.checkBox3);
        mRatingBar = findViewById(R.id.ratingBar);
        mRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                toastWithMessage(String.valueOf(v));
            }
        });
    }

    public void toastWithMessage(String message) {
        Toast.makeText(MainActivity.this,message,Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onPause() {
        super.onPause();
    }
}