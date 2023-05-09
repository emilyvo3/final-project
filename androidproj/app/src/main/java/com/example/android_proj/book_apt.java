package com.example.android_proj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

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
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) LinearLayout container = findViewById(R.id.container);

        try {
            data = CsvReaderUtil.readCsv(filePath);
            // Filter the data for each course code
            String[] courses = Member.getCoursesList().split(",\\s*");

            for (String course : courses) {
                //filtered.put(data.keySet().toString(), CsvReaderUtil.filterByCourse(String.valueOf(courses), data));
                List<Map<String, String>> appointments = CsvReaderUtil.filterByCourse(String.valueOf(courses), data);
                // Create and add views for each appointment
                for (Map<String, String> appointment : appointments) {
                    String date = appointment.get("date");
                    String time = appointment.get("time");
                    String location = appointment.get("location");

                    // Create views for appointment details
                    TextView courseCodeView = new TextView(this);
                    courseCodeView.setText(String.valueOf(courses));

                    TextView dateView = new TextView(this);
                    dateView.setText(date);

                    TextView timeView = new TextView(this);
                    timeView.setText(time);

                    TextView locationView = new TextView(this);
                    locationView.setText(location);

                    // Add views to container
                    container.addView(courseCodeView);
                    container.addView(dateView);
                    container.addView(timeView);
                    container.addView(locationView);
                }
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

class Appointment {
    private String courseCode;
    private String date;
    private String time;
    private String location;

    public Appointment(String courseCode, String date, String time, String location) {
        this.courseCode = courseCode;
        this.date = date;
        this.time = time;
        this.location = location;
    }

    // getter and setter methods omitted for brevity

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

class AppointmentAdapter extends RecyclerView.Adapter<AppointmentAdapter.ViewHolder> {
    private final List<Appointment> appointments;

    public AppointmentAdapter(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    @NonNull
    @Override
    public AppointmentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.appointment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AppointmentAdapter.ViewHolder holder, int position) {
        Appointment appointment = appointments.get(position);
        holder.courseCode.setText(appointment.getCourseCode());
        holder.date.setText(appointment.getDate());
        holder.time.setText(appointment.getTime());
        holder.location.setText(appointment.getLocation());
    }

    @Override
    public int getItemCount() {
        return appointments.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView courseCode;
        private final TextView date;
        private final TextView time;
        private final TextView location;

        public ViewHolder(View itemView) {
            super(itemView);
            courseCode = itemView.findViewById(R.id.course_code);
            date = itemView.findViewById(R.id.date);
            time = itemView.findViewById(R.id.time);
            location = itemView.findViewById(R.id.location);
        }
    }
}







