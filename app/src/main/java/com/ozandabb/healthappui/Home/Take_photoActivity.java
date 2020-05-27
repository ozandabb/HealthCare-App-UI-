package com.ozandabb.healthappui.Home;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.ozandabb.healthappui.R;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

public class Take_photoActivity extends AppCompatActivity {

    ImageView setUpImage, DefaultImage;
    private Toolbar TakePhotoToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_photo);

        TakePhotoToolBar = (Toolbar) findViewById(R.id.takephoto_toolbar);
        setSupportActionBar(TakePhotoToolBar);
        getSupportActionBar().setTitle("DermX");

        DefaultImage = findViewById(R.id.defaultImage);
        setUpImage = findViewById(R.id.setupImage);
        setUpImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    if (ContextCompat.checkSelfPermission(Take_photoActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
                        //Toast.makeText(Take_photoActivity.this,"Permission Denied", Toast.LENGTH_LONG).show();
                        ActivityCompat.requestPermissions(Take_photoActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1);
                    }else{

                        CropImage.activity()
                                .setGuidelines(CropImageView.Guidelines.ON)
                                .start(Take_photoActivity.this);
                    }
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                Uri resultUri = result.getUri();
                DefaultImage.setImageURI(resultUri);
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }
    }
}
