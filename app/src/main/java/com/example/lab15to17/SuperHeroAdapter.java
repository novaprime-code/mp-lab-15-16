package com.example.lab15to17;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SuperHeroAdapter extends RecyclerView.Adapter<SuperHeroAdapter.SuperHeroViewHolder> {
    private List<SuperHeroModel> superHeroes = new ArrayList<>();
    private ArrayList<SuperHeroModel> data;
    Activity context;
    public SuperHeroAdapter(RecyclerViewActivity recyclerViewActivity, ArrayList<SuperHeroModel> data) {
        this.context = recyclerViewActivity;
        this.data = data;
    }

    @NonNull
    @Override
    public SuperHeroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View listItem = inflater.inflate(R.layout.item_super_hero, parent, false);
        SuperHeroViewHolder viewHolder = new SuperHeroViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SuperHeroAdapter.SuperHeroViewHolder holder, int position) {
        SuperHeroModel superHero = data.get(position);
        holder.textViewName.setText(superHero.getName());
        holder.textViewPower.setText(superHero.getPower());
        holder.imageView.setImageResource(superHero.getDrawableId());
//        holder.imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (context instanceof RecyclerViewActivity) {
//                    ((RecyclerViewActivity) context).showImageDialog(superHero.getImageId());
//                }
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public static class SuperHeroViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textViewName;
        public TextView textViewPower;
        public SuperHeroViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewPower = itemView.findViewById(R.id.textViewPower);
        }
    }
}
