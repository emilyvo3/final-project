package com.example.android_proj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    int nCourses;
    String crs;

    EditText numCourse;
    EditText courses;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nCourses = (EditText) findViewById(R.id.numCourse);
        crs = (EditText) findViewById(R.id.courses);

        button = (Button) findViewById(R.id.submitButton);

        Button nextButton = findViewById(R.id.go);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NextActivity.class);
                startActivity(intent);
            }
        });
    }
}