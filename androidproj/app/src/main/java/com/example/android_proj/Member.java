package com.example.android_proj;

public class Member {
    private Integer NumberOfCourses;
    private String CoursesList;

    public Member() {
    }

    public Integer getNumberOfCourses() {
        return NumberOfCourses;
    }

    public void setNumberOfCourses(Integer numberOfCourses) {
        NumberOfCourses = numberOfCourses;
    }

    public String getCoursesList() {
        return CoursesList;
    }

    public void setCoursesList(String coursesList) {
        CoursesList = coursesList;
    }
}
