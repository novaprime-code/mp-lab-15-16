package com.example.lab15to17;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import org.jetbrains.annotations.Nullable;

import java.util.List;

public class StudentAdapter extends ArrayAdapter<Student> {
    private LayoutInflater inflater;

    public StudentAdapter(Context context, List<Student> students) {
        super(context, R.layout.list_item_student, students);
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item_student, parent, false);
        }

        Student student = getItem(position);

        TextView textViewRollNo = convertView.findViewById(R.id.textViewRollNo);
        TextView textViewName = convertView.findViewById(R.id.textViewName);
        TextView textViewAddress = convertView.findViewById(R.id.textViewAddress);

        textViewRollNo.setText(student.getRollNo());
        textViewName.setText(student.getName());
        textViewAddress.setText(student.getAddress());

        return convertView;
    }
}
