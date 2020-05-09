package com.example.ihc_exercises;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class Exercise3 extends AppCompatActivity implements SensorEventListener {
    // SensorManager - Lets you access the device's sensors
    private SensorManager sensorManager;
    // Sensor - Sensor that we will use, in this case will be Accelerometer
    private Sensor accelerometer;
    private float lastX = 0, lastY = 0, lastZ = 0;
    private boolean firstChange = true;
    private TextView xSensorText;
    private TextView ySensorText;
    private TextView zSensorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise3);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);

        xSensorText = findViewById(R.id.xSensorText);
        ySensorText = findViewById(R.id.ySensorText);
        zSensorText = findViewById(R.id.zSensorText);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        float actualX = (float) (Math.round( event.values[0] * Math.pow(10, 2)) / Math.pow(10, 2));
        float actualY = (float) (Math.round( event.values[1] * Math.pow(10, 2)) / Math.pow(10, 2));
        float actualZ = (float) (Math.round( event.values[2] * Math.pow(10, 2)) / Math.pow(10, 2));

        xSensorText.setText("X: " + Float.toString(actualX));
        ySensorText.setText("Y: " + Float.toString(actualY));
        zSensorText.setText("Z: " + Float.toString(actualZ));

        if (!firstChange){
            if( Math.abs(actualX - lastX) > 4.5 ) {
                this.showAcceleratedTooMuch("X");
            }

            if( Math.abs(actualY - lastY) > 3 ) {
                this.showAcceleratedTooMuch("Y");
            }

            if( Math.abs(actualZ - lastZ) >  4.5) {
                this.showAcceleratedTooMuch("Z");
            }
        }

        lastX = actualX;
        lastY = actualY;
        lastZ = actualZ;
        firstChange = false;

    }

    private void showAcceleratedTooMuch(String sensor) {

        Intent intent = new Intent(this, Exercise3b.class);
        intent.putExtra("MESSAGE", sensor);

        finish();
        startActivity(intent);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        sensorManager.unregisterListener(this);
        super.onPause();
    }

    public void goHome(View v){
        Intent intent = new Intent(this, MainActivity.class);
        finish();
        startActivity(intent);
    }
}
