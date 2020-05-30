package com.ozandabb.healthappui.Home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ozandabb.healthappui.R;

public class ShowResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result);
    }

    public void backtoHome(View view){
        Intent homeGo = new Intent(ShowResult.this,Take_photoActivity.class);
        startActivity(homeGo);
    }


}
