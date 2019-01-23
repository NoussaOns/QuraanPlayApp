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
        final int imageInt = getIntent().getIntExtra(Constants.IMAGE_INT.toString(), 0);
        ImageView imageView = findViewById(R.id.main_image_suraa);
        imageView.setImageResource(imageInt);


        final ArrayList<Suraa> suraas = new ArrayList<>();

        suraas.add(new Suraa(getString(R.string.fatiha), getString(R.string.fatiha_default), getString(R.string.meccan), 1, 7));
        suraas.add(new Suraa(getString(R.string.bakara), getString(R.string.bakara_default), getString(R.string.medinan), 2, 286));
        suraas.add(new Suraa(getString(R.string.al_imran), getString(R.string.al_imran_default), getString(R.string.medinan), 50, 200));
        suraas.add(new Suraa(getString(R.string.an_nisa), getString(R.string.an_nisa_default), getString(R.string.medinan), 77, 176));
        suraas.add(new Suraa(getString(R.string.al_maida), getString(R.string.al_maida_default), getString(R.string.medinan), 106, 120));
        suraas.add(new Suraa(getString(R.string.al_anam), getString(R.string.al_anam_default), getString(R.string.meccan), 128, 165));
        suraas.add(new Suraa(getString(R.string.al_araf), getString(R.string.al_araf_default), getString(R.string.meccan), 151, 206));
        suraas.add(new Suraa(getString(R.string.al_anfal), getString(R.string.al_anfal_default), getString(R.string.medinan), 177, 75));
        suraas.add(new Suraa(getString(R.string.at_tauba), getString(R.string.at_atauba_default), getString(R.string.medinan), 187, 129));
        suraas.add(new Suraa(getString(R.string.yunus), getString(R.string.yunus_default), getString(R.string.meccan), 208, 109));


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
                intent.putExtra(Constants.SURAA_DATA.toString(), suraa);
                intent.putExtra(Constants.IMAGE_INT.toString(), imageInt);
                startActivity(intent);
            }
        });

    }
}
