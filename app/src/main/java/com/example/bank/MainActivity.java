package com.example.bank;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private String PREFS_NAME = "theme", KEY_THEME = "isDark";
    private SharedPreferences prefs;
    private boolean isDark;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        isDark = prefs.getBoolean(KEY_THEME, false);
        AppCompatDelegate.setDefaultNightMode(isDark ? AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO);

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
    }

    public void pay(View v) {
        Intent intent = new Intent(this, Payment.class);
        startActivity(intent);
        finish();
    }

    public void changeTheme(View v) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(KEY_THEME, !isDark);
        editor.apply();
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }
}