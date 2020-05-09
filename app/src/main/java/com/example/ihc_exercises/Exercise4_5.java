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

public class Exercise4_5 extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor lightSensor;
    private Sensor ambientTemperatureSensor;
    private Sensor proximitySensor;
    private TextView lightText;
    private TextView ambientTemperatureText;
    private TextView proximityText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise4_5);

        lightText = findViewById(R.id.lightText);
        ambientTemperatureText = findViewById(R.id.ambientTemperatureText);
        proximityText = findViewById(R.id.proximityText);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        ambientTemperatureSensor = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);



        if(lightSensor != null)
        {
            sensorManager.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }else
        {
            lightText.setText("Light sensor not supported");
        }

        if(ambientTemperatureSensor != null)
        {
            sensorManager.registerListener(this, ambientTemperatureSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }else
        {
            ambientTemperatureText.setText("Ambient temperature sensor not supported");
        }

        if(proximitySensor != null)
        {
            sensorManager.registerListener(this, proximitySensor, SensorManager.SENSOR_DELAY_NORMAL);
        }else
        {
            proximityText.setText("Proximity sensor not supported");
        }


    }

    public void onSensorChanged(SensorEvent event) {
        Sensor sensor = event.sensor;
        if(sensor.getType() == Sensor.TYPE_LIGHT)
        {
            lightText.setText("Light Intensity: " + event.values[0] + "lx");
        }

        if(sensor.getType() == Sensor.TYPE_AMBIENT_TEMPERATURE)
        {
            ambientTemperatureText.setText("Ambient temperature: " + event.values[0] + "°C");
        }

        if(sensor.getType() == Sensor.TYPE_PROXIMITY)
        {
            if ( event.values[0]< 0.5f)
            {
                proximityText.setText("Rosto ou objeto detectado perto da tela!");
                proximityText.setTextColor(0xFF4CAF50);
            }
            else{
                proximityText.setText("Nenhum objeto detectado perto da tela");
                proximityText.setTextColor(0xFFF44336);
            }

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public void goHome(View v){
        Intent intent = new Intent(this, MainActivity.class);
        finish();
        startActivity(intent);
    }
}