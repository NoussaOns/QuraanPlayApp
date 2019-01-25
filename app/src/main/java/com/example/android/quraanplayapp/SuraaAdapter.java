package com.example.android.quraanplayapp;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent,false);
        }

        Suraa currentSuraa = getItem(position);

        TextView suraaNumber = listItemView.findViewById(R.id.suraa_number);
        TextView englishName = listItemView.findViewById(R.id.english_name);
        TextView arabicName = listItemView.findViewById(R.id.arabic_name);

        suraaNumber.setText(String.valueOf(position + 1));
        englishName.setText(currentSuraa.getNameEnglish());
        arabicName.setText(currentSuraa.getNameArabic());

        return listItemView;
    }
}
