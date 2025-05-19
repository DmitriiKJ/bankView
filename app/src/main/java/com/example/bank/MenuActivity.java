package com.example.bank;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class MenuActivity extends AppCompatActivity {

    private String PREFS_NAME = "theme", KEY_THEME = "isDark";
    private SharedPreferences prefs;
    private boolean isDark;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        isDark = prefs.getBoolean(KEY_THEME, false);
        AppCompatDelegate.setDefaultNightMode(isDark ? AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO);

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu);
    }

    public void loan(View v) {
        Intent intent = new Intent(this, LoanActivity.class);
        startActivity(intent);
        finish();
    }

    public void deposit(View v) {
        Intent intent = new Intent(this, DepositActivity.class);
        startActivity(intent);
        finish();
    }

    public void save(View v) {
        Intent intent = new Intent(this, SaveActivity.class);
        startActivity(intent);
        finish();
    }

    public void pay(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
