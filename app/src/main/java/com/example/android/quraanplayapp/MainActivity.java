package com.example.android.quraanplayapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<Sheikh> sheikhs = new ArrayList<>();
        sheikhs.add(new Sheikh(getString(R.string.ahmed_alnafees), R.drawable.ahmed_nafees));
        sheikhs.add(new Sheikh(getString(R.string.fares_abbad), R.drawable.fares_abbad));
        sheikhs.add(new Sheikh(getString(R.string.islam_sobhi), R.drawable.islam_sobhi));
        sheikhs.add(new Sheikh(getString(R.string.maher_almaikly), R.drawable.maher_almaiqly));
        sheikhs.add(new Sheikh(getString(R.string.msallam_almashali), R.drawable.msallam_mashali));
        sheikhs.add(new Sheikh(getString(R.string.nasser_alqattami), R.drawable.naser_alqtami));
        sheikhs.add(new Sheikh(getString(R.string.saad_alghamdi), R.drawable.saad_alghamdy));
        sheikhs.add(new Sheikh(getString(R.string.tameem_arrimi), R.drawable.tameen_reemi));


        GridView gridView = findViewById(R.id.sheikh_gridview);
        SheikhAdapter sheikhAdapter = new SheikhAdapter(this, sheikhs);
        gridView.setAdapter(sheikhAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Sheikh sheikh = sheikhs.get(position);
                Intent intent = new Intent(MainActivity.this, SuraaActivity.class);
                // get the current image item and send it as an extra to the next activity
                intent.putExtra(Constants.IMAGE_INT.toString(), sheikh.getImageResourceId());
                startActivity(intent);
            }
        });

    }
}
