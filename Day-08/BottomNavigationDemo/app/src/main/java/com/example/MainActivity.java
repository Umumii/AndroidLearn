package com.example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView mBottomNavigationView;
    NavController mNavController;
    AppBarConfiguration mAppBarConfiguration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBottomNavigationView = findViewById(R.id.bottomNavigationView);
        mNavController = Navigation.findNavController(this,R.id.fragment);
        //mNavController.getGraph() 带返回按钮 mBottomNavigationView.getMenu() 不带返回按钮
        mAppBarConfiguration = new AppBarConfiguration.Builder(mBottomNavigationView.getMenu()).build();
        NavigationUI.setupActionBarWithNavController(this,mNavController,mAppBarConfiguration);
        NavigationUI.setupWithNavController(mBottomNavigationView,mNavController);
    }
}