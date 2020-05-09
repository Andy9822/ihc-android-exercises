package com.example.ihc_exercises;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private TextView resultView;
    private EditText num1;
    private EditText num2;

    private EditText inputExercise2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultView = (TextView) findViewById(R.id.resultTextView);
        num1 = (EditText) findViewById(R.id.num1);
        num2 = (EditText) findViewById(R.id.num2);

        inputExercise2 = (EditText) findViewById(R.id.inputExercise2);
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

    public void openExercise1(View v){
        Intent intent = new Intent(this, Exercise1.class);
        finish();
        startActivity(intent);
    }

    public void openExercise2(View v){
        String textEx2 = inputExercise2.getText().toString();

        Intent intent = new Intent(this, Exercise2.class);
        intent.putExtra("MESSAGE",textEx2);

        finish();
        startActivity(intent);
    }

    public void openExercise3(View v){
        Intent intent = new Intent(this, Exercise3.class);
        finish();
        startActivity(intent);
    }
}