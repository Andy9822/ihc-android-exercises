package com.example.ihc_exercises;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import android.content.Intent;

public class Exercise2 extends AppCompatActivity {

    private TextView textView;
    private Button goBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise2);

        textView = (TextView) findViewById(R.id.textView);
        goBackButton = (Button) findViewById(R.id.goBackButton);

        Intent intent = getIntent();
        String text = intent.getStringExtra("MESSAGE");
        textView.setText(text);

    }

    public void goBack(View v){
        Intent intent = new Intent(this, MainActivity.class);
        finish();
        startActivity(intent);
    }
}