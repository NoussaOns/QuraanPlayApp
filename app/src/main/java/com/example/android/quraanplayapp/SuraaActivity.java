package com.example.android.quraanplayapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

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

        ArrayList<Suraa> suraas = new ArrayList<>();

        suraas.add(new Suraa("The Opening","Al-Fatihah","Makkah",1,7));
        suraas.add(new Suraa("The Cow","Al-Baqarah","Medina",2,286));
        suraas.add(new Suraa("The Family of Amran","Al-'Imran","Medina",50,200));
        suraas.add(new Suraa("The Women","An-Nisa'","Medina",77,176));
        suraas.add(new Suraa("The Food","Al-Ma'idah","Medina",106,120));
        suraas.add(new Suraa("The Cattle","Al-An'am","Makkah",128,165));
        suraas.add(new Suraa("The Elevated Place","Al-A'raf","Makkah",151,206));
        suraas.add(new Suraa("Voluntary Gifts","Al-Anfal","Medina",177,75));
        suraas.add(new Suraa("The Immunity","At-Taubah","Medina",187,129));
        suraas.add(new Suraa("Jonah","Yunus","Makkah",208,109));


        ListView listView = findViewById(R.id.list_view_suraas);
        SuraaAdapter suraaAdapter = new SuraaAdapter(this,suraas);
        listView.setAdapter(suraaAdapter);

    }
}
