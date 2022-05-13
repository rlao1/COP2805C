package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    static double yenRate = 126.99;
    static double cadRate = 1.26;
    static double eurRate = 0.93;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String currency = getIntent().getStringExtra("currencySelected");
        TextView txtExtra = (TextView) findViewById(R.id.textView_extra);
        txtExtra.setText(currency);

        Button btnExtra = (Button) findViewById(R.id.btn_toExtra);
        btnExtra.setText("TO " + currency);

        TextView numExtra = (TextView) findViewById(R.id.number_extra);
        if(currency.equals("YEN")) {
            numExtra.setText(String.valueOf(yenRate));
        }
        else if(currency.equals("CAD")) {
            numExtra.setText(String.valueOf(cadRate));
        }
        else if(currency.equals("EUR")) {
            numExtra.setText(String.valueOf(eurRate));
        }
    }

    public void goBack(View v) {
        finish();
    }

    public void convertToEXT(View v) {
        TextView txtExtra = (TextView) findViewById(R.id.textView_extra);
        String currency = txtExtra.getText().toString();

        EditText numUsd = (EditText) findViewById(R.id.number_usd);
        double input = Double.valueOf(numUsd.getText().toString());

        EditText numExtra = (EditText) findViewById(R.id.number_extra);

        if(currency.equals("YEN")) {
            numExtra.setText(String.format("%.4f", input * yenRate));
        }
        else if(currency.equals("CAD")) {
            numExtra.setText(String.format("%.4f", input * cadRate));
        }
        else if(currency.equals("EUR")) {
            numExtra.setText(String.format("%.4f", input * eurRate));
        }
    }

    public void convertToUSD(View v) {
        TextView txtExtra = (TextView) findViewById(R.id.textView_extra);
        String currency = txtExtra.getText().toString();

        EditText numExtra = (EditText) findViewById(R.id.number_extra);
        double input = Double.valueOf(numExtra.getText().toString());

        EditText numUsd = (EditText) findViewById(R.id.number_usd);

        if(currency.equals("YEN")) {
            numUsd.setText(String.format("%.4f", input / yenRate));
        }
        else if(currency.equals("CAD")) {
            numUsd.setText(String.format("%.4f", input / cadRate));
        }
        else if(currency.equals("EUR")) {
            numUsd.setText(String.format("%.4f", input / eurRate));
        }
    }
}