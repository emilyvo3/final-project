package com.example.android_proj;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class homepage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);

        Button startButton = findViewById(R.id.start);
        startButton.setOnClickListener(v -> {
            Intent intent = new Intent(homepage.this, student_input.class);
            startActivity(intent);
        });
    }
}
