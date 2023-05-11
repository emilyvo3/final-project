package com.example.android_proj;

public class Member {
    private static String UserName;
    private static String CoursesList;

    public Member() {
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public static String getCoursesList() {
        return CoursesList;
    }

    public void setCoursesList(String coursesList) {CoursesList = coursesList;}
}
