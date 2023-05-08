package com.example.android_proj;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.io.IOException;

public class book_appt extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_appt);

        Button submitButton = findViewById(R.id.submit);
        submitButton.setOnClickListener(v -> {
            // Call readCsv method with the appropriate file path
            String filePath = "app/sampledata/ASC.csv";

            try {
                CsvReaderUtil.readCsv(filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Start the confirmation activity
            Intent intent = new Intent(book_appt.this, confirmation.class);
            startActivity(intent);
        });
    }
}





