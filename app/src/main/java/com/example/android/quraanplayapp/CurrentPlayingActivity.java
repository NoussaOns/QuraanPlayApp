package com.example.android.quraanplayapp;

import android.content.Intent;
import androidx.core.app.NavUtils;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CurrentPlayingActivity extends AppCompatActivity {
    //declared as final because when it was in the method onClick it showed an error because of
    // toggling the boolean
    boolean isPressed = false;

    @BindView(R.id.current_playing_image) ImageView imageView;
    @BindView(R.id.play_arrow) ImageView playArrow;
    @BindView(R.id.suraa_name_arabic) TextView suraaNameArabic;
    @BindView(R.id.suraa_name_english) TextView suraaNameEnglish;
    @BindView(R.id.suraa_page) TextView suraPage;
    @BindView(R.id.suraa_place) TextView suraPlace;
    @BindView(R.id.suraa_verses) TextView suraVerses;

    @OnClick (R.id.play_arrow) public void changePlayButton(){
        //iterate between the pause and play buttons
        isPressed = !isPressed;
        playArrow.setImageResource(isPressed ? R.drawable.ic_pause_black_24dp : R.drawable.ic_play_arrow_black_24dp);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:

                //if you need to still have the same state on the main activity,
                Intent intent = NavUtils.getParentActivityIntent(this);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                NavUtils.navigateUpTo(this, intent);

                //By specifying the parent activity name in the manifest it will always set the
                // parent activity to be restarted. If you don't want this you have the option
                // to provide a different functionality for the up button as below. Ideally you
                // want to do this in a base activity so all your activities who need a similar
                // back behavior do the same instead of placing below code in every activity.
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_playing);

        ButterKnife.bind(this);
        //show the up navigation
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //get the sheikh data from previous activity
        final Sheikh sheikh = getIntent().getParcelableExtra(Constants.SHEIKH_DATA.toString());
        //set the activity image to the sheikh's image
        imageView.setImageResource(sheikh.getImageResourceId());

        Suraa suraa = getIntent().getParcelableExtra(Constants.SURAA_DATA.toString());

        //set activity title with the suraa's name
        setTitle(suraa.getNameArabic());


        suraaNameArabic.setText(suraa.getNameArabic());
        suraaNameEnglish.setText(suraa.getNameEnglish());
        suraPage.setText(getString(R.string.page) + " " + suraa.getPage());
        suraPlace.setText(getString(R.string.place) + " " + suraa.getPlace());
        suraVerses.setText(getString(R.string.verses) + " " + suraa.getNumberOfVerses());

    }
}
