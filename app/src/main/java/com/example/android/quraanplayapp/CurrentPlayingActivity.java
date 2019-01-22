package com.example.android.quraanplayapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class CurrentPlayingActivity extends AppCompatActivity {
    //declared as final because when it was in the method onClick it showed an error because of
    // toggling the boolean
    boolean isPressed = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_playing);

        final ImageView playArrow = findViewById(R.id.play_arrow);


        playArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isPressed = !isPressed;
                playArrow. setImageResource(isPressed ? R.drawable.ic_play_arrow_black_24dp : R.drawable.ic_pause_black_24dp);
            }
        });
    }
}
