package com.example.ihc_exercises;

import android.Manifest;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Exercise6 extends AppCompatActivity implements OnMapReadyCallback {

    private TextView latitudeView;
    private TextView longitudView;

    boolean isMapReady = false;
    private static final String MAPVIEW_BUNDLE_KEY = "AIzaSyDN8HPwhoLvmMekCq3T7FJSmP5bRpj5iXs";
    GoogleMap map;
    private MapView mMapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise6);

        latitudeView = findViewById(R.id.latitudeView);
        longitudView = findViewById(R.id.longitudView);

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 123);

        Bundle mapViewBundle = null;
        if (savedInstanceState != null) {
            mapViewBundle = savedInstanceState.getBundle(MAPVIEW_BUNDLE_KEY);
        }

        mMapView = (MapView) findViewById(R.id.mapView);
        mMapView.onCreate(mapViewBundle);

        mMapView.getMapAsync(this);
    }


    public void showCoordinates(View v){
        if (isMapReady){
            GPSTracker g = new GPSTracker(getApplicationContext());
            Location l = g.getLocation();

            if(l!=null)
            {
                double lat = l.getLatitude();
                double longit = l.getLongitude();

                latitudeView.setText("Latitude: " + Double.toString(lat));
                longitudView.setText("Longitude" + Double.toString(longit));

                LatLng myLocation = new LatLng(lat, longit);
                map.addMarker(new MarkerOptions().position(myLocation).title("Localização"));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(myLocation, 10));
            }
        }


    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Bundle mapViewBundle = outState.getBundle(MAPVIEW_BUNDLE_KEY);
        if (mapViewBundle == null) {
            mapViewBundle = new Bundle();
            outState.putBundle(MAPVIEW_BUNDLE_KEY, mapViewBundle);
        }

        mMapView.onSaveInstanceState(mapViewBundle);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        isMapReady = true;
        this.map = map;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mMapView.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mMapView.onStop();
    }

    @Override
    protected void onPause() {
        mMapView.onPause();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        mMapView.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }

    public void goHome(View v){
        Intent intent = new Intent(this, MainActivity.class);
        finish();
        startActivity(intent);
    }
}
