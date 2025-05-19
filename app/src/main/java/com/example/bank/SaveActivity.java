package com.example.bank;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class SaveActivity extends AppCompatActivity {
    private String PREFS_NAME = "theme", KEY_THEME = "isDark";
    private SharedPreferences prefs;
    private boolean isDark;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        isDark = prefs.getBoolean(KEY_THEME, false);
        AppCompatDelegate.setDefaultNightMode(isDark ? AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO);

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_save);

        String[] items = {"Будинок", "Машина", "Життя"};
        Spinner sp = findViewById(R.id.spSave);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spiner_item, items);

        sp.setAdapter(adapter);

        String[] prices = {"Звичайна", "Преміум", "Люкс"};
        Spinner sp2 = findViewById(R.id.spPrem);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, R.layout.spiner_item, prices);

        sp2.setAdapter(adapter2);
    }
}
