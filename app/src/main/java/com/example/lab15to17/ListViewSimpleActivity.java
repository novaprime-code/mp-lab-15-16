package com.example.lab15to17;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListViewSimpleActivity extends AppCompatActivity {
    private Button btnBack, btnGetListViewData;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_simple_activity);



        listView = findViewById(R.id.listView);
        btnBack = findViewById(R.id.btnBack);
        btnGetListViewData = findViewById(R.id.btnGetListViewData);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnGetListViewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                populateListView();
            }
        });


    }

    private void populateListView(){
        List<Student> students = new ArrayList<>();
        students.add(new Student("100101", "Robert Downey Jr.", "123 Main Street, Anytown, USA, 12345"));
        students.add(new Student("100110", "Chris Hemsworth ", "456 Elm Avenue, Springfield, USA, 67890"));
        students.add(new Student("100111", "Mark Ruffalo", "789 Oak Lane, Metro City, USA, 54321"));
        students.add(new Student("101000", "Benedict Cumberbatch", "987 Maple Drive, Rivertown, USA, 13579"));
        students.add(new Student("101001", "Tom Hiddleston", "654 Pine Street, Lakeside, USA, 97531"));
        students.add(new Student("101010", "Chris Evans ", "321 Cedar Road, Mountain View, USA, 71953"));
        students.add(new Student("101011", "Tom Holland ", "876 Birch Lane, Oceanville, USA, 39284"));
        students.add(new Student("101100", "Chris Pratt ", "543 Walnut Avenue, Harbor City, USA, 48620"));
        students.add(new Student("101101", "Scarlett Johansson ", "210 Spruce Court, Meadowbrook, USA, 85246"));
        MyListAdapter adapter = new MyListAdapter(this, students);
        listView.setAdapter(adapter);
    }
}