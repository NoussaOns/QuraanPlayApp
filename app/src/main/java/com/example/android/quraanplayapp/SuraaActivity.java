package com.example.android.quraanplayapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;

public class SuraaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suraa);

        //get the image source from the previous activity
        int imageInt = getIntent().getIntExtra("Image Int",0);
        ImageView imageView = findViewById(R.id.main_image_suraa);
        imageView.setImageResource(imageInt);

    }
}
