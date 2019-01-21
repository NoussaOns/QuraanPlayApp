package com.example.android.quraanplayapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Sheikh> sheikhs = new ArrayList<>();
        sheikhs.add(new Sheikh("Ahmed Al-Nafees", R.drawable.ahmed_nafees));
        sheikhs.add(new Sheikh("Fares Abbad", R.drawable.fares_abbad));
        sheikhs.add(new Sheikh("Islam Sobhi", R.drawable.islam_sobhi));
        sheikhs.add(new Sheikh("Maher Al-Maikly", R.drawable.maher_almaiqly));
        sheikhs.add(new Sheikh("Msallam Al-Mas'hali", R.drawable.msallam_mashali));
        sheikhs.add(new Sheikh("Nasser Al-Kattami", R.drawable.naser_alqtami));
        sheikhs.add(new Sheikh("Saad Al-Ghamdi", R.drawable.saad_alghamdy));
        sheikhs.add(new Sheikh("Tameem Arrimi", R.drawable.tameen_reemi));


        GridView gridView = findViewById(R.id.sheikh_gridview);
        SheikhAdapter sheikhAdapter = new SheikhAdapter(this,sheikhs);
        gridView.setAdapter(sheikhAdapter);

    }
}
