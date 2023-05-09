package com.example.android_proj;
import com.example.android_proj.CsvReaderUtil;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class book_apt extends AppCompatActivity {

    private List<Appointment> appointmentList;
    private AppointmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_appt);

        appointmentList = new ArrayList<>();
        adapter = new AppointmentAdapter();

        RecyclerView recyclerView = findViewById(R.id.appointmentRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        String filePath = "app/sampledata/ASC.csv";

        try {
            Map<String, List<Map<String, String>>> data = CsvReaderUtil.readCsv(filePath);

            for (Map.Entry<String, List<Map<String, String>>> entry : data.entrySet()) {
                String course = entry.getKey();
                List<Map<String, String>> appointments = entry.getValue();

                for (Map<String, String> appointment : appointments) {
                    String tutorFirstName = appointment.get("tutorFirst");
                    String tutorLastName = appointment.get("tutorLast");
                    String appointmentTime = appointment.get("time");
                    String appointmentLocation = appointment.get("location");

                    Appointment newAppointment = new Appointment(course, tutorFirstName, tutorLastName, appointmentTime, appointmentLocation);
                    appointmentList.add(newAppointment);
                }
            }

            adapter.setAppointments(appointmentList); // Update the adapter's appointment list
            adapter.notifyDataSetChanged(); // Notify the adapter that the data has changed

        } catch (IOException e) {
            e.printStackTrace();
        }

        Button submitButton = findViewById(R.id.submit);
        submitButton.setOnClickListener(v -> {
            Intent intent = new Intent(book_apt.this, confirmation.class);
            startActivity(intent);
        });
    }

    private static class Appointment {
        private final String courseCode;
        private final String tutorFirstName;
        private final String tutorLastName;
        private final String appointmentTime;
        private final String appointmentLocation;

        public Appointment(String courseCode, String tutorFirstName, String tutorLastName, String appointmentTime, String appointmentLocation) {
            this.courseCode = courseCode;
            this.tutorFirstName = tutorFirstName;
            this.tutorLastName = tutorLastName;
            this.appointmentTime = appointmentTime;
            this.appointmentLocation = appointmentLocation;
        }

        public String getCourseCode() {
            return courseCode;
        }

        public String getTutorFirstName() {
            return tutorFirstName;
        }

        public String getTutorLastName() {
            return tutorLastName;
        }

        public String getAppointmentTime() {
            return appointmentTime;
        }

        public String getAppointmentLocation() {
            return appointmentLocation;
        }
    }


    private class AppointmentAdapter extends RecyclerView.Adapter<AppointmentAdapter.ViewHolder> {
        private List<Appointment> appointments;

        public AppointmentAdapter() {
            appointments = new ArrayList<>();
        }

        public void setAppointments(List<Appointment> appointments) {
            this.appointments = appointments;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_appointment, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Appointment appointment = appointments.get(position);
            holder.courseCode.setText(appointment.getCourseCode());
            holder.tutorName.setText(appointment.getTutorFirstName() + " " + appointment.getTutorLastName());
            holder.appointmentTime.setText(appointment.getAppointmentTime());
            holder.appointmentLocation.setText(appointment.getAppointmentLocation());
        }

        @Override
        public int getItemCount() {
            return appointments.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            private final TextView courseCode;
            private final TextView tutorName;
            private final TextView appointmentTime;
            private final TextView appointmentLocation;

            public ViewHolder(View itemView) {
                super(itemView);
                courseCode = itemView.findViewById(R.id.course_code);
                tutorName = itemView.findViewById(R.id.tutor_name);
                appointmentTime = itemView.findViewById(R.id.time);
                appointmentLocation = itemView.findViewById(R.id.location);
            }

            public void bind(Appointment appointment) {
                courseCode.setText(appointment.getCourseCode());
                tutorName.setText(appointment.getTutorFirstName() + " " + appointment.getTutorLastName());
                appointmentTime.setText(appointment.getAppointmentTime());
                appointmentLocation.setText(appointment.getAppointmentLocation());
            }
        }
    }
}







