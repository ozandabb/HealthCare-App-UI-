package com.ozandabb.healthappui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate;
import com.ozandabb.healthappui.Home.CreateAccount;
import com.ozandabb.healthappui.Home.MainActivity;
import com.ozandabb.healthappui.Home.Take_photoActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void goHome(View view){
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void goToRegister(View view){
        Intent goreg = new Intent(LoginActivity.this, CreateAccount.class);
        startActivity(goreg);
    }
}
