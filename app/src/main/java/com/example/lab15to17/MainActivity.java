package com.example.lab15to17;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnListView, btnGridView, btnRecyclerView, btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnListView =findViewById(R.id.btnListView);
        btnGridView = findViewById(R.id.btnGridView);
        btnRecyclerView = findViewById(R.id.btnRecyclerView);


        btnListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
                startActivity(intent);
            }
        });
        btnGridView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
                Toast.makeText(MainActivity.this,"Clicked on Gridview Activator", Toast.LENGTH_SHORT).show();
//                startActivity(intent);
            }
        });
        btnRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
                Toast.makeText(MainActivity.this,"Clicked on Recycler Activator", Toast.LENGTH_SHORT).show();
//                startActivity(intent);
            }
        });
    }
}