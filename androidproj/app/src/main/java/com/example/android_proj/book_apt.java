package com.example.android_proj;
//import com.example.android_proj.CsvReaderUtil;

//import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class book_apt extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_appt);

        LinearLayout container = findViewById(R.id.container);

        //String filePath = "/androidproj/app/sampledata/ASC.csv";
        File file = new File(getFilesDir(),"sampledata/ASC.csv");

        try {
            // Get the list of courses from your desired source
            //String coursesList = Member.getCoursesList();
            String[] courses = Member.getCoursesList().split(",\\s");
            Map<String, List<Map<String, String>>> data = CsvReaderUtil.readCsv(file);

            // Get the filtered data for each course code
            for (String course:courses) {
                //String course = entry.getKey();
                // Filter the data for the current course code
                List<Map<String, String>> filteredAppointments = CsvReaderUtil.filterByCourse(course, data);
                // Filter the data for the current course code
                //List<Map<String, String>> filteredAppointments = CsvReaderUtil.filterByCourse(course, data);
                for (Map<String, String> appointment : filteredAppointments) {
                    String tutorFirstName = appointment.get("tutorFirst");
                    String tutorLastName = appointment.get("tutorLast");
                    String appointmentTime = appointment.get("time");
                    String appointmentLocation = appointment.get("location");

                    // Create a new LinearLayout for the appointment details
                    LinearLayout appointmentLayout = new LinearLayout(this);
                    appointmentLayout.setLayoutParams(new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                    ));
                    appointmentLayout.setOrientation(LinearLayout.VERTICAL);

                    // Create TextViews for each appointment detail
                    TextView courseTextView = new TextView(this);
                    courseTextView.setId(R.id.course_code);
                    courseTextView.setText(course);
                    appointmentLayout.addView(courseTextView);

                    TextView tutorNameTextView = new TextView(this);
                    String tutorName = getString(R.string.tutor_name_format, tutorFirstName, tutorLastName);
                    tutorNameTextView.setId(R.id.tutor_name);
                    tutorNameTextView.setText(tutorName);
                    appointmentLayout.addView(tutorNameTextView);

                    TextView appointmentTimeTextView = new TextView(this);
                    appointmentTimeTextView.setId(R.id.appointment_time);
                    appointmentTimeTextView.setText(appointmentTime);
                    appointmentLayout.addView(appointmentTimeTextView);

                    TextView appointmentLocationTextView = new TextView(this);
                    appointmentLocationTextView.setId(R.id.appointment_location);
                    appointmentLocationTextView.setText(appointmentLocation);
                    appointmentLayout.addView(appointmentLocationTextView);

                    // Add the appointment LinearLayout to the container
                    container.addView(appointmentLayout);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Button submitButton = findViewById(R.id.submit);
        submitButton.setOnClickListener(v -> {
            Intent intent = new Intent(book_apt.this, confirmation.class);
            startActivity(intent);
        });
    }
}












