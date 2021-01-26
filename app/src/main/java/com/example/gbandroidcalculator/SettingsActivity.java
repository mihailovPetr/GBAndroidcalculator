package com.example.gbandroidcalculator;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {
    private int choosenTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = getSharedPreferences(MainActivity.APP_PREFERENCES, MODE_PRIVATE);
        int theme = sharedPreferences.getInt(MainActivity.CURRENT_THEME, R.style.StandardTheme);
        setTheme(theme);

        setContentView(R.layout.activity_settings);

        RadioGroup radioGroup = findViewById(R.id.radioGroup);

        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case -1:
                    break;
                case R.id.radioButton1:
                    choosenTheme = R.style.StandardTheme;
                    break;
                case R.id.radioButton2:
                    choosenTheme = R.style.OrangeTheme;
                    break;
                case R.id.radioButton3:
                    choosenTheme = R.style.DarkTheme;
                    break;
                default:
                    break;
            }
        });
        //SharedPreferences sharedPreferences = getSharedPreferences(MainActivity.APP_PREFERENCES, MODE_PRIVATE);
        choosenTheme = sharedPreferences.getInt(MainActivity.CURRENT_THEME, R.style.StandardTheme);

        RadioButton r;
        switch (choosenTheme) {
            case R.style.StandardTheme:
                r = findViewById(R.id.radioButton1);
                r.setChecked(true);
                break;
            case R.style.OrangeTheme:
                r = findViewById(R.id.radioButton2);
                r.setChecked(true);
                break;
            case R.style.DarkTheme:
                r = findViewById(R.id.radioButton3);
                r.setChecked(true);
                break;
        }

        Button okButton = findViewById(R.id.ok_button);
        okButton.setOnClickListener(okButtonOnClickListener);
    }

    View.OnClickListener okButtonOnClickListener = v -> {
        SharedPreferences sharedPreferences = getSharedPreferences(MainActivity.APP_PREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(MainActivity.CURRENT_THEME, choosenTheme);
        editor.apply();
        setResult(RESULT_OK);
        finish();
    };
}