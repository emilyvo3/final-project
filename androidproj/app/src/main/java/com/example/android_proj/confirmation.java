package com.example.android_proj;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
//import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class confirmation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmation);

        TextView textView = findViewById(R.id.aptDetails);

        // Retrieve the selected data from the intent
        dataSample selectedData = getIntent().getParcelableExtra("selectedData");

        if (selectedData != null) {
            textView.setText(selectedData.getFirstName() + "'s Appointment Details:\n");
            textView.append("Course: " + selectedData.getCourse() + "\n");
            textView.append("Tutor: " + selectedData.getFirstName() + " " + selectedData.getLastName() + "\n");
            textView.append("Time: " + selectedData.getTime() + "\n");
            textView.append("Location: " + selectedData.getLocation());
        }

        Button confirmButton = findViewById(R.id.confirm);
        confirmButton.setOnClickListener(v -> {
            Toast.makeText(confirmation.this, "Success", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(confirmation.this, homepage.class);
            startActivity(intent);
        });

        Button backButton = findViewById(R.id.goback);
        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(confirmation.this, book_apt.class);
            startActivity(intent);
        });
    }

}