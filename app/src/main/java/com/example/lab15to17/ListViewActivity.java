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
    private Button btnBack;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_activity);

        listView = findViewById(R.id.listView);
        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        new FetchStudentData().execute();
    }
    private void displayStudents(List<Student> students){
        ArrayAdapter<Student> adapter = new ArrayAdapter<Student>(this, R.layout.list_item_student, students);
        // Set the adapter on the ListView
        listView.setAdapter(adapter);
    }

    private class FetchStudentData extends AsyncTask<Void, Void, List<Student>>{
        @Override
        protected List<Student> doInBackground(Void... voids){
            List<Student> students =  new ArrayList<>();
            try {
                URL url = new URL("http://localhost/mp_practical_api/get_students.php");
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
                        String rollNo = jsonObject.getString("rollNo");
                        String name = jsonObject.getString("fullname");
                        String address = jsonObject.getString("address");
                        students.add(new Student(rollNo, name, address));
                    }
                }
            }catch (Exception e){
                Toast.makeText(ListViewActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
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

    private void displayToast(final String message) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(ListViewActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}