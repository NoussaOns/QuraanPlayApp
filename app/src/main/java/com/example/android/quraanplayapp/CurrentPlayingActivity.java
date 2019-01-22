package com.example.android.quraanplayapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CurrentPlayingActivity extends AppCompatActivity {
    //declared as final because when it was in the method onClick it showed an error because of
    // toggling the boolean
    boolean isPressed = false;
    TextView suraaName, suraPage, suraVerses, suraPlace;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_playing);

        //get the image source from the previous activity
        final int imageInt = getIntent().getIntExtra("Image Int",0);
        ImageView imageView = findViewById(R.id.current_playing_image);
        imageView.setImageResource(imageInt);

        Intent i = getIntent();
        String suraNameInt = i.getStringExtra("Suraa name");
        int suraPageInt = i.getIntExtra("Suraa page",0);
        String suraPlaceInt = i.getStringExtra("Suraa place");
        int suraVersesInt = i.getIntExtra("Suraa verses",0);

        suraaName = findViewById(R.id.suraa_name);
        suraPage = findViewById(R.id.suraa_page);
        suraPlace = findViewById(R.id.suraa_place);
        suraVerses = findViewById(R.id.suraa_verses);

        suraaName.setText(String.valueOf(suraNameInt));
        suraPage.setText("Page: " + String.valueOf(suraPageInt));
        suraPlace.setText("Place: " + String.valueOf(suraPlaceInt));
        suraVerses.setText("Verses: " + String.valueOf(suraVersesInt));

        final ImageView playArrow = findViewById(R.id.play_arrow);


        playArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isPressed = !isPressed;
                playArrow. setImageResource(isPressed ? R.drawable.ic_pause_black_24dp : R.drawable.ic_play_arrow_black_24dp);
            }
        });
    }
}
