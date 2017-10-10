package com.phattarapong.learnrxjava;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Phattarapong on 10/9/2017.
 */

public class PlanetsAdapter extends RecyclerView.Adapter<PlanetsAdapter.ViewHolder> {

    private List<Planets.ResultsBean> planetsList;
    private Context context;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movies, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.titleLabel.setText(planetsList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return planetsList == null ? 0 : planetsList.size();
    }

    public void addItem(List<Planets.ResultsBean> planetsList, Context context) {
        if (planetsList == null) {
            planetsList = new ArrayList<>();
        }
        this.context = context;
        this.planetsList = planetsList;
        notifyDataSetChanged();
    }

    public void clear() {
        if (planetsList != null) {
            planetsList.clear();
            notifyDataSetChanged();
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView titleLabel;

        public ViewHolder(View itemView) {
            super(itemView);
            titleLabel =  itemView.findViewById(R.id.titleLabel);
        }
    }
}
