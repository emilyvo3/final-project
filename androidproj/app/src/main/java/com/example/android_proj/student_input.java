package com.example.android_proj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class student_input extends AppCompatActivity {

    /*int nCourses;
    String crs;*/

    EditText coursesNums;
    EditText coursesList;

    Button button;

    FirebaseDatabase fDatabase;
    DatabaseReference dRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_input);



        coursesNums = findViewById(R.id.coursesNums);
        coursesList = findViewById(R.id.coursesList);

/*// Get the text values of the EditText views
        String coursesNumText = coursesNums.getText().toString();
        String coursesListText = coursesList.getText().toString();

// Parse the text values to int and String types
         nCourses = Integer.parseInt(coursesNumText);
         crs = coursesListText;*/


        button =  findViewById(R.id.submit);


        button.setOnClickListener(v -> {
            // Get data from text boxes
            String coursesNumText = coursesNums.getText().toString();
            int nCourses = Integer.parseInt(coursesNumText);
            String crs = coursesList.getText().toString();

            // Store data in Firebase database
            fDatabase = FirebaseDatabase.getInstance();
            dRef = fDatabase.getReference("data1");
            dRef.child("nCourses").setValue(nCourses);
            dRef.child("crs").setValue(crs);

            // Start new activity
            Intent intent = new Intent(student_input.this, book_appt.class);
            startActivity(intent);
        });




    }
}