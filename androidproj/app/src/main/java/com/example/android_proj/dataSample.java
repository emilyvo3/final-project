package com.example.android_proj;
import android.os.Parcel;
import android.os.Parcelable;

public class dataSample implements Parcelable {
    private String Course;
    private String LastName;
    private String FirstName;
    private String Location;
    private String Time;

    public dataSample() {
        // Empty constructor required by Parcelable
    }

    protected dataSample(Parcel in) {
        Course = in.readString();
        LastName = in.readString();
        FirstName = in.readString();
        Location = in.readString();
        Time = in.readString();
    }

    public static final Creator<dataSample> CREATOR = new Creator<dataSample>() {
        @Override
        public dataSample createFromParcel(Parcel in) {
            return new dataSample(in);
        }

        @Override
        public dataSample[] newArray(int size) {
            return new dataSample[size];
        }
    };

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

    public void setLocation(String location) {
        Location = location;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Course);
        dest.writeString(LastName);
        dest.writeString(FirstName);
        dest.writeString(Location);
        dest.writeString(Time);
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
