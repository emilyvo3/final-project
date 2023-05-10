package com.example.android_proj;
public class dataSample {
    private String Course;
    private String LastName;
    private String FirstName;
    private String Location;
    private String Time;

    public String getCourse() {
        return Course;
    }

    public void setCourse(String course) {
        Course = course;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String sundayLocation) {
        Location = sundayLocation;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String sundayTime) {
        Time = sundayTime;
    }



    @Override
    public String toString() {
        return "dataSample{" +
                "Course='" + Course + '\'' +
                ", LastName='" + LastName + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", Location='" + Location + '\'' +
                ", Time='" + Time + '\'' +
                '}';
    }
}