package com.example.lab15to17;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {
    private Button btnListView, btnGridView, btnRecyclerView, btnBack;
    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recylerViewLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_activity);

        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               finish();
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        ArrayList<SuperHeroModel> data = new ArrayList<SuperHeroModel>();
        data.add(new SuperHeroModel("Superman", "Flying", "https://www.superherodb.com/pictures2/portraits/10/100/791.jpg", R.drawable.wal1));
        data.add(new SuperHeroModel("Batman", "Rich", "https://www.superherodb.com/pictures2/portraits/10/100/639.jpg", R.drawable.wal2));
        data.add(new SuperHeroModel("Spiderman", "Spider", "https://www.superherodb.com/pictures2/portraits/10/100/133.jpg", R.drawable.wal3));
        data.add(new SuperHeroModel("Ironman", "Suit", "https://www.superherodb.com/pictures2/portraits/10/100/85.jpg", R.drawable.wal4));
        data.add(new SuperHeroModel("Thor", "Hammer", "https://www.superherodb.com/pictures2/portraits/10/100/140.jpg", R.drawable.wal5));
        data.add(new SuperHeroModel("Hulk", "Smash", "https://www.superherodb.com/pictures2/portraits/10/100/83.jpg", R.drawable.wal6));
        data.add(new SuperHeroModel("Captain America", "Shield", "https://www.superherodb.com/pictures2/portraits/10/100/274.jpg", R.drawable.wal7));
        data.add(new SuperHeroModel("Black Widdow", "Spy", "https://www.superherodb.com/pictures2/portraits/10/100/1305.jpg", R.drawable.wal8));

        recylerViewLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(recylerViewLayoutManager);

        recyclerViewAdapter = new SuperHeroAdapter(this, data);
        recyclerView.setAdapter(recyclerViewAdapter);

    }
}