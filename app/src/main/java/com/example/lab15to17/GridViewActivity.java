package com.example.lab15to17;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

public class GridViewActivity extends AppCompatActivity {
    private ImageGridAdapter adapter;
    private Button btnGetGridViewData, btnBack;
    private  Integer[] imageIds  = {
            R.drawable.wal,
            R.drawable.wal1,
            R.drawable.wal10,
            R.drawable.wal2,
            R.drawable.wal3,
            R.drawable.wal4,
            R.drawable.wal5,
            R.drawable.wal6,
            R.drawable.wal7,
            R.drawable.wal8,
            R.drawable.wal9

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_view_activity);

        GridView gridView = findViewById(R.id.gridView);
        btnBack = findViewById(R.id.btnBack);
        btnGetGridViewData = findViewById(R.id.btnGetGridViewData);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnGetGridViewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 adapter = new ImageGridAdapter(GridViewActivity.this, imageIds);
                gridView.setAdapter(adapter);
            }
        });


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                showImageDialog(imageIds[position]);
            }
        });


    }

    public  void showImageDialog(int imageId){
        Dialog dialog = new Dialog(GridViewActivity.this);
        dialog.setContentView(R.layout.image_dialog);

        ImageView expandedImage =  dialog.findViewById(R.id.expandedImage);
        expandedImage.setImageResource(imageId);
        dialog.show();
    }
}