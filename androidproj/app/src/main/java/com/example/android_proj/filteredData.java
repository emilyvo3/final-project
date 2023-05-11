package com.example.android_proj;

public class filteredData {
    dataSample data;

    String uName;

    public void setName(String uName) {
        this.uName = uName;
    }

    public String getName(){
        return uName;
    }

    public void setData(dataSample bkApp){
        data.setCourse(bkApp.getCourse());
        data.setFirstName(bkApp.getFirstName());
        data.setLastName(bkApp.getLastName());
        data.setTime(bkApp.getTime());
        data.setLocation(bkApp.getLocation());

    }

    public dataSample getData(){
        return data;
    }

}
