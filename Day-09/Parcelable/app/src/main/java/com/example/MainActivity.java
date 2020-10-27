package com.example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = binding.editTextName.getText().toString();
                int age = Integer.parseInt(binding.editTextAge.getText().toString());
                int math = Integer.parseInt(binding.editTextMath.getText().toString());
                int chinese = Integer.parseInt(binding.editTextChinese.getText().toString());
                Student student = new Student(name,age,new Score(math,chinese));

//                MyApplication myApplication = (MyApplication) getApplication();
//                myApplication.mStudent = student;

                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable("student", student);
                intent.putExtra("data", bundle);
                startActivity(intent);
            }
        });
    }
}