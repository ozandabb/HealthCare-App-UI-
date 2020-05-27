package com.ozandabb.healthappui.Run;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ozandabb.healthappui.Home.MainActivity;
import com.ozandabb.healthappui.R;
import com.ozandabb.healthappui.Device.deviceActivity;
import com.ozandabb.healthappui.Exercise.exerciseActivity;
import com.ozandabb.healthappui.Profile.profileActivity;

public class runningActivity extends FragmentActivity implements OnMapReadyCallback {
    private static final String TAG = "runningActivity";
    private static final int ACTIVITY_NUM = 2;

    GoogleMap map;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_run);

        setupBottomNavBar();
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private void setupBottomNavBar(){
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavViewBar);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.ic_home:
                        Intent homeIntent = new Intent(runningActivity.this, MainActivity.class);
                        startActivity(homeIntent);
                        break;
                    case R.id.ic_heart:
                        Intent ExerciseIntent = new Intent(runningActivity.this, exerciseActivity.class);
                        startActivity(ExerciseIntent);
                        break;
                    case R.id.ic_run:
                        Intent runIntent = new Intent(runningActivity.this,runningActivity.class);
                        startActivity(runIntent);
                        break;
                    case R.id.ic_device:
                        Intent deviceIntent = new Intent(runningActivity.this, deviceActivity.class);
                        startActivity(deviceIntent);
                        break;
                    case R.id.ic_profile:
                        Intent profileIntent = new Intent(runningActivity.this, profileActivity.class);
                        startActivity(profileIntent);
                        break;


                }

                return false;
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

        LatLng srilanka = new LatLng(61.588810, 98.858847);
        map.addMarker(new MarkerOptions().position(srilanka).title("Sri Lanka"));
        map.moveCamera(CameraUpdateFactory.newLatLng(srilanka));
    }
}
