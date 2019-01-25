package com.example.android.quraanplayapp;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SheikhAdapter extends ArrayAdapter<Sheikh> {

    public SheikhAdapter(Context context, ArrayList<Sheikh> sheikhs) {
        super(context, 0, sheikhs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        //get the data item for this position
        Sheikh currentSheikh = getItem(position);

        //check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder); //view lookup cache stored in tag
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //populate the data into the tempelate view sing data object
        viewHolder.sheikhName.setText(currentSheikh.getName());
        viewHolder.sheikhImage.setImageResource(currentSheikh.getImageResourceId());
        viewHolder.sheikhImage.setVisibility(View.VISIBLE);

        //return the completed view to render on screen
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.sheikh_image)
        ImageView sheikhImage;
        @BindView(R.id.sheikh_name)
        TextView sheikhName;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
