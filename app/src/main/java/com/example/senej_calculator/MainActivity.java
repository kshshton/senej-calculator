package com.example.senej_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText h1;
    private EditText h1Result;
    private EditText detal;
    private EditText detalPercentage;
    private EditText detalResult;
    private EditText s;
    private EditText sPercentage;
    private EditText sResult;
    private EditText h2;
    private EditText h2Percentage;
    private EditText h2Result;
    private final double vat = 1.23;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        h1 = findViewById(R.id.editTextNumber6);
        h1Result = findViewById(R.id.editTextNumber7);
        detal = findViewById(R.id.editTextNumber);
        detalPercentage = findViewById(R.id.editTextNumber10);
        detalResult = findViewById(R.id.editTextNumber5);
        s = findViewById(R.id.editTextNumber8);
        sPercentage = findViewById(R.id.editTextNumber12);
        sResult = findViewById(R.id.editTextNumber3);
        h2 = findViewById(R.id.editTextNumber4);
        h2Percentage = findViewById(R.id.editTextNumber13);
        h2Result = findViewById(R.id.editTextNumber2);

        androidx.appcompat.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.action_bar_bg));
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        actionBar.setDisplayShowCustomEnabled(true);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.logo, null);
        actionBar.setCustomView(view);
    }

    public void count(View view) {
        try {
            double h1Value = Double.parseDouble(h1.getText().toString());
            h1Result.setText(String.valueOf(Math.round(nettoResult(h1Value))));

            double detalPercentageValue = Double.parseDouble(detalPercentage.getText().toString());
            detal.setText(String.valueOf(Math.round(percentageResult(h1Value, detalPercentageValue))));
            double detalValue = Double.parseDouble(detal.getText().toString());
            detalResult.setText(String.valueOf(Math.round(nettoResult(detalValue))));

            double sPercentageValue = Double.parseDouble(sPercentage.getText().toString());
            s.setText(String.valueOf(Math.round(percentageResult(h1Value, sPercentageValue))));
            double sValue = Double.parseDouble(s.getText().toString());
            sResult.setText(String.valueOf(Math.round(nettoResult(sValue))));

            double h2PercentageValue = Double.parseDouble(h2Percentage.getText().toString());
            h2.setText(String.valueOf(Math.round(percentageResult(h1Value, h2PercentageValue))));
            double h2Value = Double.parseDouble(h2.getText().toString());
            h2Result.setText(String.valueOf(Math.round(nettoResult(h2Value))));
        } catch (Exception e) {}
    }

    public double percentageResult(double value, double percentage) {
        return value + (value * (percentage / 100));
    }

    public double nettoResult(double value) {
        return value / vat;
    }

    public void clear(View view) {
        h1.setText("");
        h1Result.setText("");
        detal.setText("");
        detalResult.setText("");
        s.setText("");
        sResult.setText("");
        h2.setText("");
        h2Result.setText("");
        detalPercentage.setText("25");
        sPercentage.setText("-8");
        h2Percentage.setText("-15");
    }
}