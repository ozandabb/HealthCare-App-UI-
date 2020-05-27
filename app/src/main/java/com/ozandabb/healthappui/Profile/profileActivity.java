package com.ozandabb.healthappui.Profile;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ozandabb.healthappui.Device.deviceActivity;
import com.ozandabb.healthappui.Exercise.exerciseActivity;
import com.ozandabb.healthappui.Home.MainActivity;
import com.ozandabb.healthappui.R;
import com.ozandabb.healthappui.Run.runningActivity;

public class profileActivity extends AppCompatActivity {
    private static final String TAG = "profileActivity";
    private static final int ACTIVITY_NUM = 4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        setupBottomNavBar();
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
                        Intent homeIntent = new Intent(profileActivity.this, MainActivity.class);
                        startActivity(homeIntent);
                        break;
                    case R.id.ic_heart:
                        Intent ExerciseIntent = new Intent(profileActivity.this, exerciseActivity.class);
                        startActivity(ExerciseIntent);
                        break;
                    case R.id.ic_run:
                        Intent runIntent = new Intent(profileActivity.this, runningActivity.class);
                        startActivity(runIntent);
                        break;
                    case R.id.ic_device:
                        Intent deviceIntent = new Intent(profileActivity.this, deviceActivity.class);
                        startActivity(deviceIntent);
                        break;
                    case R.id.ic_profile:
                        Intent profileIntent = new Intent(profileActivity.this,profileActivity.class);
                        startActivity(profileIntent);
                        break;


                }

                return false;
            }
        });
    }
}
