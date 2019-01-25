package com.example.android.quraanplayapp;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;

public class SuraaAdapter extends ArrayAdapter<Suraa> {

    public SuraaAdapter(Context context, ArrayList<Suraa> suraas){
        super(context,0,suraas);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder viewHolder;
        //get the data item for this position
        Suraa currentSuraa = getItem(position);

        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
            viewHolder.arabicName = convertView.findViewById(R.id.arabic_name);
            viewHolder.englishName = convertView.findViewById(R.id.english_name);
            viewHolder.suraaNumber = convertView.findViewById(R.id.suraa_number);
            convertView.setTag(viewHolder); //view lookup cache stored in tag
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //populate the data into the tempelate view sing data object
        viewHolder.suraaNumber.setText(String.valueOf(position + 1));
        viewHolder.englishName.setText(currentSuraa.getNameEnglish());
        viewHolder.arabicName.setText(currentSuraa.getNameArabic());

        //return the completed view to render on screen
        return convertView;
    }

    private static class ViewHolder {
        TextView suraaNumber, englishName, arabicName;
    }
}
