package com.example.android.quraanplayapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;


public class SuraaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suraa);

        //get the image source from the previous activity
        final int imageInt = getIntent().getIntExtra("Image Int", 0);
        ImageView imageView = findViewById(R.id.main_image_suraa);
        imageView.setImageResource(imageInt);


        final ArrayList<Suraa> suraas = new ArrayList<>();

        suraas.add(new Suraa("The Opening", "Al-Fatihah", getString(R.string.meccan), 1, 7));
        suraas.add(new Suraa("The Cow", "Al-Baqarah", getString(R.string.medinan), 2, 286));
        suraas.add(new Suraa("The Family of Amran", "Al-'Imran", getString(R.string.medinan), 50, 200));
        suraas.add(new Suraa("The Women", "An-Nisa'", getString(R.string.medinan), 77, 176));
        suraas.add(new Suraa("The Food", "Al-Ma'idah", getString(R.string.medinan), 106, 120));
        suraas.add(new Suraa("The Cattle", "Al-An'am", getString(R.string.meccan), 128, 165));
        suraas.add(new Suraa("The Elevated Place", "Al-A'raf", getString(R.string.meccan), 151, 206));
        suraas.add(new Suraa("Voluntary Gifts", "Al-Anfal", getString(R.string.medinan), 177, 75));
        suraas.add(new Suraa("The Immunity", "At-Taubah", getString(R.string.medinan), 187, 129));
        suraas.add(new Suraa("Jonah", "Yunus", getString(R.string.meccan), 208, 109));


        //attach the list view to the custon sura adapter from the above arrayList
        ListView listView = findViewById(R.id.list_view_suraas);
        SuraaAdapter suraaAdapter = new SuraaAdapter(this, suraas);
        listView.setAdapter(suraaAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //send the clicked list item to the next activity
                Suraa suraa = suraas.get(position);
                Intent intent = new Intent(new Intent(SuraaActivity.this, CurrentPlayingActivity.class));
                // get the current image and suraa data and send them as an extra to the next activity
                intent.putExtra("suraaData",suraa);
                intent.putExtra("Image Int", imageInt);
                startActivity(intent);
            }
        });

    }
}
