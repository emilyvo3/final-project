package com.example.android_proj;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class book_apt extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_appt);

        String filePath = "app/sample data/ASC.csv";
        Map<String, List<Map<String, String>>> data;
        Map<String, List<Map<String, String>>> filtered = null;

        try {
            data = CsvReaderUtil.readCsv(filePath);
            // Filter the data for each course code
            for (String courseCode : data.keySet()) {
                filtered.put(data.keySet().toString(), CsvReaderUtil.filterByCourse(courseCode, data));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Button submitButton = findViewById(R.id.submit);
        submitButton.setOnClickListener(v -> {
            // Call readCsv method with the appropriate file path


            // Start the confirmation activity
            Intent intent = new Intent(book_apt.this, confirmation.class);
            startActivity(intent);
        });
    }
}





