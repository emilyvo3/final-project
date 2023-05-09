package com.example.android_proj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class confirmation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmation);

        Button confirmButton = findViewById(R.id.confirm);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(confirmation.this, "Success", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(confirmation.this, homepage.class);
                startActivity(intent);
            }
        });

        Button backButton = findViewById(R.id.goback);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(confirmation.this, book_apt.class);
                startActivity(intent);
            }
        });
    }
}