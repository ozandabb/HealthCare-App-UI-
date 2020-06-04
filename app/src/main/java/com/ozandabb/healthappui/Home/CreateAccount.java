package com.ozandabb.healthappui.Home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ozandabb.healthappui.LoginActivity;
import com.ozandabb.healthappui.R;

public class CreateAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
    }

    public void goToLogin(View view){
        Intent intent = new Intent(CreateAccount.this, LoginActivity.class);
        startActivity(intent);
    }
}
