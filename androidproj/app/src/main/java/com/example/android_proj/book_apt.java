package com.example.android_proj;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class book_apt extends AppCompatActivity {
    private TextView courseTextView;
    private Button submit;

    private dataSample selectedAppointment;

    private final List<dataSample> dataSamples = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_appt);

        courseTextView = findViewById(R.id.courseTextView);
        submit = findViewById(R.id.submit);

        readData();

        String inputCourses = getIntent().getStringExtra("crsName");

        filterAndDisplayCourses(inputCourses);
    }

    private void readData() {
        InputStream is = getResources().openRawResource(R.raw.input);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, StandardCharsets.UTF_8)
        );
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                if (tokens.length >= 6) {
                    dataSample sample = new dataSample();
                    sample.setCourse(tokens[0]);
                    sample.setLastName(tokens[1]);
                    sample.setFirstName(tokens[2]);
                    sample.setLocation(tokens[4]);
                    sample.setTime(tokens[5]);
                    // Set other sample properties as needed
                    dataSamples.add(sample);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressLint("SetTextI18n")
    private void filterAndDisplayCourses(String inputCourses) {
        LinearLayout layout = findViewById(R.id.courseButtonsLayout);
        layout.removeAllViews(); // Clear any previously displayed buttons
        String name = getIntent().getStringExtra("name");

        for (dataSample sample : dataSamples) {
            String course = sample.getCourse();
            String lastName = sample.getLastName();
            String firstName = sample.getFirstName();
            String location = sample.getLocation();
            String time = sample.getTime();

            // Check if the course matches any of the input courses
            for (String inputCourse : inputCourses.split(",")) {
                if (course.equalsIgnoreCase(inputCourse.trim())) {
                    Button button = new Button(this);
                    button.setText(course + ": " + lastName + ", " + firstName + " " + location + " " + time);
                    button.setOnClickListener(v -> {
                        selectedAppointment = sample;
                        Toast.makeText(book_apt.this, "Appointment selected: " + course + ": " + lastName + ", " + firstName, Toast.LENGTH_SHORT).show();
                    });

                    layout.addView(button); // Add the button to the layout
                    break; // Exit the loop after finding a match for the current course
                }
            }
        }

        if (layout.getChildCount() == 0) {
            // No matching courses found
            courseTextView.setText("No matching courses found");
        } else {
            // Clear the text view when buttons are displayed
            courseTextView.setText("");
        }

        submit.setOnClickListener(v -> {
            if (selectedAppointment != null) {
                Intent intent = new Intent(book_apt.this, confirmation.class);
                intent.putExtra("selectedData", selectedAppointment);
                intent.putExtra("name", name);
                startActivity(intent);
            } else {
                Toast.makeText(book_apt.this, "Please select an appointment", Toast.LENGTH_SHORT).show();
            }
        });
    }
}












