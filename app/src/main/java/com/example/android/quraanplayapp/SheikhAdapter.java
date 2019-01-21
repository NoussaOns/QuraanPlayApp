package com.example.android.quraanplayapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SheikhAdapter extends ArrayAdapter<Sheikh> {

    public SheikhAdapter(Context context, ArrayList<Sheikh> sheikhs){
        super(context,0,sheikhs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View gridItemView = convertView;
        if (gridItemView == null){
            gridItemView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent,false);
        }

        Sheikh currentSheikh = getItem(position);
        TextView sheikhName = gridItemView.findViewById(R.id.sheikh_name);
        ImageView sheikhImage = gridItemView.findViewById(R.id.sheikh_image);


        sheikhName.setText(currentSheikh.getName());
        sheikhImage.setImageResource(currentSheikh.getImageResourceId());
        sheikhImage.setVisibility(View.VISIBLE);

        return gridItemView;

    }
}
