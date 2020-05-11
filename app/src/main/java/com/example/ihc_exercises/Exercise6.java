package com.example.ihc_exercises;

import android.Manifest;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class Exercise6 extends AppCompatActivity{

    private TextView latitudeView;
    private TextView longitudView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise6);

        latitudeView = findViewById(R.id.latitudeView);
        longitudView = findViewById(R.id.longitudView);

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 123);
    }


    public void showCoordinates(View v){
        GPSTracker g = new GPSTracker(getApplicationContext());
        Location l = g.getLocation();

        if(l!=null)
        {
            double lat = l.getLatitude();
            double longit = l.getLongitude();

            latitudeView.setText("Latitude: " + Double.toString(lat));
            longitudView.setText("Longitude" + Double.toString(longit));


        }

    }

    public void goHome(View v){
        Intent intent = new Intent(this, MainActivity.class);
        finish();
        startActivity(intent);
    }
}
