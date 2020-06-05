package com.ozandabb.healthappui.Home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ozandabb.healthappui.LoginActivity;
import com.ozandabb.healthappui.R;
import com.ozandabb.healthappui.Device.deviceActivity;
import com.ozandabb.healthappui.Exercise.exerciseActivity;
import com.ozandabb.healthappui.Profile.profileActivity;
import com.ozandabb.healthappui.Run.runningActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static final int ACTIVITY_NUM = 0;
    private Toolbar mainToolbar;

//    ImageView setUpImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupBottomNavBar();
//        setUpViewPager();

        mainToolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(mainToolbar);
        getSupportActionBar().setTitle("E-Health Care");

    }

    public void goTakePhoto(View view){
        Intent intent = new Intent(MainActivity.this,Take_photoActivity.class);
        startActivity(intent);
    }

//    private void setUpViewPager(){
//        sectionPagerAdapter adapter = new sectionPagerAdapter(getSupportFragmentManager());
//        adapter.adFragment(new homeFragment());
////        adapter.adFragment(new cameraFragment());
//        adapter.adFragment(new settingFragment());
//        ViewPager viewPager = (ViewPager) findViewById(R.id.container);
//        viewPager.setAdapter(adapter);
//
//        TabLayout tabLayout = findViewById(R.id.tabs);
//        tabLayout.setupWithViewPager(viewPager);
//
//        tabLayout.getTabAt(0).setIcon(R.drawable.ic_posts);
////        tabLayout.getTabAt(1).setIcon(R.drawable.ic_camera);
//        tabLayout.getTabAt(1).setIcon(R.drawable.ic_settings);
//
//    }

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
                        Intent homeIntent = new Intent(MainActivity.this,MainActivity.class);
                        startActivity(homeIntent);
                        break;
                    case R.id.ic_heart:
                        Intent ExerciseIntent = new Intent(MainActivity.this, exerciseActivity.class);
                        startActivity(ExerciseIntent);
                        break;
                    case R.id.ic_run:
                        Intent runIntent = new Intent(MainActivity.this, runningActivity.class);
                        startActivity(runIntent);
                        break;
                    case R.id.ic_device:
                        Intent deviceIntent = new Intent(MainActivity.this, deviceActivity.class);
                        startActivity(deviceIntent);
                        break;
                    case R.id.ic_profile:
                        Intent profileIntent = new Intent(MainActivity.this, profileActivity.class);
                        startActivity(profileIntent);
                        break;


                }

                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_dermx:
                Intent homeIntent = new Intent(MainActivity.this, ActivityDermx.class);
                startActivity(homeIntent);
                return true;

            case R.id.action_logout:
                Intent LogOutIntent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(LogOutIntent);
                return true;

            case R.id.action_language:
                Intent language = new Intent(MainActivity.this, Language.class);
                startActivity(language);
                return true;

            case R.id.action_scans:
                Intent scans = new Intent(MainActivity.this, Take_photoActivity.class);
                startActivity(scans);
                return true;

            case R.id.action_settings_btn:
                Intent settings = new Intent(MainActivity.this, Settings.class);
                startActivity(settings);
                return true;

//            case R.id.action_blood:
//                return true;


            default:
                return false;
        }

    }
}
