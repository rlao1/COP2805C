package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startSecond(View v) {
        RadioGroup radioCurrency = (RadioGroup) findViewById(R.id.radio_currency);

        if(radioCurrency.getCheckedRadioButtonId() != -1) {
            RadioButton selectedBtn = (RadioButton) findViewById(radioCurrency.getCheckedRadioButtonId());
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("currencySelected", selectedBtn.getText().toString());
            startActivity(intent);
        }
    }
}