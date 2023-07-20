package com.example.lab15to17;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnListView, btnGridView, btnRecyclerView, btnListViewSimple;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnListView =findViewById(R.id.btnListView);
        btnGridView = findViewById(R.id.btnGridView);
        btnRecyclerView = findViewById(R.id.btnRecyclerView);
        btnListViewSimple = findViewById(R.id.btnListViewSimple);


        btnListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
                startActivity(intent);
            }
        });
        btnListViewSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListViewSimpleActivity.class);
                startActivity(intent);
            }
        });
        btnGridView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GridViewActivity.class);
                Toast.makeText(MainActivity.this,"Clicked on Gridview Activator", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
        btnRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
                Toast.makeText(MainActivity.this,"Clicked on Recycler Activator", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }
}