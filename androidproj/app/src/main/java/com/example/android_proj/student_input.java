package com.example.android_proj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.text.TextUtils;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class student_input extends AppCompatActivity {
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
        button =  findViewById(R.id.submit);

/*// Get the text values of the EditText views
        String coursesNumText = coursesNums.getText().toString();
        String coursesListText = coursesList.getText().toString();

// Parse the text values to int and String types
         nCourses = Integer.parseInt(coursesNumText);
         crs = coursesListText;*/

        button.setOnClickListener(v -> {
            // Get data from text boxes
            String coursesNumText = coursesNums.getText().toString().trim();
            //int nCourses = Integer.parseInt(coursesNumText);
            //String crs = coursesList.getText().toString();
            String coursesListText = coursesList.getText().toString().trim();

            if (TextUtils.isEmpty(coursesNumText) || TextUtils.isEmpty(coursesListText)) {
                Toast.makeText(student_input.this, "Please enter both number of courses and course list.", Toast.LENGTH_SHORT).show();
                return;
            }

            int nCourses;
            try {
                nCourses = Integer.parseInt(coursesNumText);
            } catch (NumberFormatException e) {
                Toast.makeText(student_input.this, "Please enter a valid number for number of courses.", Toast.LENGTH_SHORT).show();
                return;
            }

            // Store data in Firebase database
            fDatabase = FirebaseDatabase.getInstance();
            dRef = fDatabase.getReference().child("userInput");
            dRef.child("coursesNums").setValue(nCourses);
            dRef.child("coursesNums").addValueEventListener(new ValueEventListener() {
                //@SuppressLint("SetTextI18n")
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists()) {
                        coursesNums.setText(snapshot.getValue(String.class));
                    } else {
                        coursesNums.setText("Not Found");
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

            dRef.child("coursesList").setValue(coursesListText);
            dRef.child("coursesList").addValueEventListener(new ValueEventListener() {
                //@SuppressLint("SetTextI18n")
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists()) {
                        coursesList.setText(snapshot.getValue(String.class));
                    } else {
                        coursesList.setText("Not Found");
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
            // Start new activity
            Intent intent = new Intent(student_input.this, book_appt.class);
            startActivity(intent);
        });
    }
}