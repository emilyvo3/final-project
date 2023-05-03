package com.example.android_proj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;

public class student_input extends AppCompatActivity {

    /*int nCourses;
    String crs;

    EditText coursesNums;
    EditText coursesList;*/

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_input);



        /*coursesNums = findViewById(R.id.coursesNums);
        coursesList = findViewById(R.id.coursesList);

// Get the text values of the EditText views
        String coursesNumText = coursesNums.getText().toString();
        String coursesListText = coursesList.getText().toString();

// Parse the text values to int and String types
         nCourses = Integer.parseInt(coursesNumText);
         crs = coursesListText;*/


        button =  findViewById(R.id.submit);


        button.setOnClickListener(v -> {
            Intent intent = new Intent(student_input.this, book_appt.class);
            startActivity(intent);
        });



    }
}