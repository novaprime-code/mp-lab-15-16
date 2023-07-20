package com.example.lab15to17;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {
    private Button btnBack, btnGetListViewData;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_activity);

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
                new FetchStudentData().execute();
            }
        });


    }
    private void displayStudents(List<Student> students){
        StudentAdapter adapter = new StudentAdapter(this, students);
        listView.setAdapter(adapter);
    }

    private void displayToast(final String message) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(ListViewActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }
    private class FetchStudentData extends AsyncTask<Void, Void, List<Student>>{
        @Override
        protected List<Student> doInBackground(Void... voids){
            List<Student> students =  new ArrayList<>();
            try {
                URL url = new URL("https://jsonplaceholder.typicode.com/users/");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                int responseCode = connection.getResponseCode();
                if(responseCode == HttpURLConnection.HTTP_OK){
                    InputStream inputStream = connection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder response = new StringBuilder();
                    String line;

                    while ((line = bufferedReader.readLine()) != null) {
                        response.append(line);
                    }

                    bufferedReader.close();
                    inputStream.close();

                    JSONArray jsonArray = new JSONArray(response.toString());
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String rollNo = jsonObject.getString("id");
                        String name = jsonObject.getString("name");
//                        String address = jsonObject.getString("address");
                        JSONObject addressObject = jsonObject.getJSONObject("address");
                        String street = addressObject.getString("street");
                        String suite = addressObject.getString("suite");
                        String city = addressObject.getString("city");
                        String address = street +", " + suite + ", "+city;
                        students.add(new Student(rollNo, name, address));
                    }
                }
            }catch (Exception e){
                displayToast(e.getMessage());
            }
            return students;
        }

        @Override
        protected void onPostExecute(List<Student> students) {
            super.onPostExecute(students);
            displayStudents(students);

        }

        @Override
        protected void onCancelled(List<Student> students) {
            super.onCancelled(students);
            displayToast("Task cancelled");
        }
    }

}