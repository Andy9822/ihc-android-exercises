package com.example.ihc_exercises;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import android.content.Intent;

public class Exercise1 extends AppCompatActivity {

    private TextView resultView;
    private EditText num1;
    private EditText num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise1);

        resultView = findViewById(R.id.resultTextView);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
    }

    public void sumValues(View v){
        try {
            int firstValue = Integer.parseInt(num1.getText().toString());
            int secondValue = Integer.parseInt(num2.getText().toString());

            int sum = firstValue + secondValue;
            String resul = "Resultado = ";
            resultView.setText(resul + Integer.toString(sum));
        } catch (NumberFormatException e) {

        }

    }

    public void goHome(View v){
        Intent intent = new Intent(this, MainActivity.class);
        finish();
        startActivity(intent);
    }
}