package com.example.ihc_exercises;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Exercise3b extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise3b);

        textView = (TextView) findViewById(R.id.textView);

        Intent intent = getIntent();
        String sensor = intent.getStringExtra("MESSAGE");
        textView.setText(sensor);

    }

    public void goHome(View v){
        Intent intent = new Intent(this, MainActivity.class);
        finish();
        startActivity(intent);
    }

    public void goBack(View v){
        Intent intent = new Intent(this, Exercise3.class);
        finish();
        startActivity(intent);
    }
}