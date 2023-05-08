package com.example.android_proj;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class student_input extends AppCompatActivity {
    EditText textBoxNum, coursesList;
    Button submit;
    DatabaseReference reff;
    Member member;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FirebaseApp.initializeApp(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_input);

        textBoxNum = (EditText)findViewById(R.id.textBoxNum);
        coursesList = (EditText)findViewById(R.id.coursesList);
        submit = (Button)findViewById(R.id.submit);
        member = new Member();
        reff = FirebaseDatabase.getInstance().getReference().child("User Input");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number = Integer.parseInt(textBoxNum.getText().toString().trim());

                member.setNumberOfCourses(number);
                member.setCoursesList(coursesList.getText().toString().trim());
                reff.child("Student").setValue(member);
                Toast.makeText(student_input.this,"data inserted successfully",Toast.LENGTH_LONG).show();
            }
        });
    }
}
