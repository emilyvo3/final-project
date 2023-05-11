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

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        filteredData fData = new filteredData();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmation);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView textView = (TextView) findViewById(R.id.aptDetails);
        textView.setText(fData.getName()+"'s Appointment Details: \n");
        textView.setText("Course: " + fData.getData().getCourse());
        textView.setText("Tutor: " + fData.getData().getFirstName() + " " + fData.getData().getLastName()+ "\n");
        textView.setText("Time: " + fData.getData().getTime());
        textView.setText("Location: " + fData.getData().getLocation());


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