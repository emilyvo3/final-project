package com.example.android_proj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class student_input extends AppCompatActivity {
    EditText textBoxName, coursesList;
    Button submit;
    DatabaseReference reff;
    Member member;

    filteredData fData;
    long max_id = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FirebaseApp.initializeApp(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_input);

        textBoxName = (EditText)findViewById(R.id.textBoxName);
        coursesList = (EditText)findViewById(R.id.coursesList);
        submit = (Button)findViewById(R.id.submit);
        member = new Member();
        reff = FirebaseDatabase.getInstance().getReference().child("User Input");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //DataSnapshot dataSnapshot = null;
                if(dataSnapshot.exists())
                    max_id = dataSnapshot.getChildrenCount();
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = textBoxName.getText().toString().trim();
                String crs = coursesList.getText().toString();

                fData = new filteredData(); // Instantiate the fData object
                fData.setName(name);
                member.setCoursesList(crs);
                reff.child("Student " + (max_id + 1)).setValue(member);
                reff.child("Student " + (max_id + 1)).child("coursesList").setValue(crs);
                Toast.makeText(student_input.this,"Data successfully inserted",Toast.LENGTH_LONG).show();

                Intent intent = new Intent(student_input.this, book_apt.class);
                intent.putExtra("crsName", crs);
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });
    }
}

