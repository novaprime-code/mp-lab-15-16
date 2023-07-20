package com.example.lab15to17;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ImageGridAdapter extends ArrayAdapter<Integer> {
    private Context context;
    private  Integer[] imageIds;
    public  ImageGridAdapter(Context context, Integer[] imageIds){
        super(context, 0, imageIds);
        this.context = context;
        this.imageIds = imageIds;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ImageView imageView ;
        if(convertView == null){
            imageView = (ImageView) LayoutInflater.from(context).inflate(R.layout.grid_item_image, parent, false);
        }else{
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(imageIds[position]);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (context instanceof GridViewActivity) {
                    ((GridViewActivity) context).showImageDialog(imageIds[position]);
                }
            }
        });
        return imageView;
    }


}
