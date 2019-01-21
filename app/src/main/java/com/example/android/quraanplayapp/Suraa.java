package com.example.android.quraanplayapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Suraa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suraa);

        int imageInt = getIntent().getIntExtra("Image Int",0); // oops should be a fallback if an error happens
        ImageView imageView = findViewById(R.id.main_image_suraa);
        imageView.setImageResource(imageInt);
    }
}
