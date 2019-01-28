package com.example.android.quraanplayapp;

import android.content.Context;
import androidx.annotation.NonNull;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * recycler view tutorial
 * https://medium.com/@droidbyme/android-recyclerview-fca74609725e
 */
public class SuraaAdapter extends RecyclerView.Adapter<SuraaAdapter.SuraaHolder> {

    Context context;
    private ArrayList<Suraa> suraas;

    public SuraaAdapter(Context context, ArrayList<Suraa> suraas) {
        this.context = context;
        this.suraas = suraas;
    }

    @NonNull
    @Override
    public SuraaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_view_item, parent, false);
        return new SuraaHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SuraaHolder holder, int position) {
        Suraa suraa = suraas.get(position);
        holder.setDetails(suraa, position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(new Intent(context, CurrentPlayingActivity.class));
                // get the current image and suraa data and send them as an extra to the next activity
                intent.putExtra(Constants.SURAA_DATA.toString(), suraa);
                intent.putExtra(Constants.SHEIKH_DATA.toString(), SuraaActivity.sheikh);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return suraas.size();
    }

    //the viewHolder
    public class SuraaHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.arabic_name)
        TextView arabicName;
        @BindView(R.id.english_name)
        TextView englishName;
        @BindView(R.id.suraa_number)
        TextView suraaNumber;

        public SuraaHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        // I have added the position parameter by myself. (Not in the tutorial)
        public void setDetails(Suraa suraa, int position) {
            //populate the data into the tempelate view sing data object
            suraaNumber.setText(String.valueOf(position + 1));
            englishName.setText(suraa.getNameEnglish());
            arabicName.setText(suraa.getNameArabic());
        }
    }
}
