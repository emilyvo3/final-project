package com.example.android_proj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class student_input extends AppCompatActivity {

    int nCourses;
    String crs;

    EditText numCourse;
    EditText courses;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_input);

        nCourses = (EditText) findViewById(R.id.numCourse);
        crs = (EditText) findViewById(R.id.courses);

        //button = (Button) findViewById(R.id.submitButton);

        Button submitButton = findViewById(R.id.submit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(student_input.this, book_appt.class);
                startActivity(intent);
            }
        });
    }
}