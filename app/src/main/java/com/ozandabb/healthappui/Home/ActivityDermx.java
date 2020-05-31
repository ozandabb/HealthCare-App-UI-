package com.ozandabb.healthappui.Home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.ozandabb.healthappui.Device.deviceActivity;
import com.ozandabb.healthappui.Exercise.exerciseActivity;
import com.ozandabb.healthappui.Profile.profileActivity;
import com.ozandabb.healthappui.R;
import com.ozandabb.healthappui.Run.runningActivity;

public class ActivityDermx extends AppCompatActivity {

    private static final String TAG = "ActivityDermx";
    private static final int ACTIVITY_NUM = 0;
    private Toolbar mainToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dermx);

        setupBottomNavBar();
        setUpViewPager();
        mainToolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(mainToolbar);
        getSupportActionBar().setTitle("E-Health Care");
    }

    private void setUpViewPager(){
        sectionPagerAdapter adapter = new sectionPagerAdapter(getSupportFragmentManager());
        adapter.adFragment(new DermxWhatFragment());
        adapter.adFragment(new DermxSympotosFragment());
        adapter.adFragment(new DermxTreatmentFragment());
        ViewPager viewPager = (ViewPager) findViewById(R.id.container);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.question);
        tabLayout.getTabAt(1).setIcon(R.drawable.sysm);
        tabLayout.getTabAt(2).setIcon(R.drawable.treat);

    }

    public void GOtAKEpHOTO(View view){
        Intent intent = new Intent(ActivityDermx.this, Take_photoActivity.class);
        startActivity(intent);
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
                        Intent homeIntent = new Intent(ActivityDermx.this,MainActivity.class);
                        startActivity(homeIntent);
                        break;
                    case R.id.ic_heart:
                        Intent ExerciseIntent = new Intent(ActivityDermx.this, exerciseActivity.class);
                        startActivity(ExerciseIntent);
                        break;
                    case R.id.ic_run:
                        Intent runIntent = new Intent(ActivityDermx.this, runningActivity.class);
                        startActivity(runIntent);
                        break;
                    case R.id.ic_device:
                        Intent deviceIntent = new Intent(ActivityDermx.this, deviceActivity.class);
                        startActivity(deviceIntent);
                        break;
                    case R.id.ic_profile:
                        Intent profileIntent = new Intent(ActivityDermx.this, profileActivity.class);
                        startActivity(profileIntent);
                        break;


                }

                return false;
            }
        });
    }
}
