package com.henna.lopputyo.data;

public class ClassCourse extends Course {
    private String classRoom = "";
    private String day = "";
    private String time = "";
    private double length = 0.0; // in hours


    public ClassCourse(String classRoom, String day, String time, double length) {
        super("", 0, "");
        this.classRoom = classRoom;
        this.day = day;
        this.time = time;
        this.length = length;
        createID();
    }

    public String getClassRoom() {
        return this.classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public String getDay() {
        return this.day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getLength() {
        return this.length;
    }

    public void setLength(double length) {
        this.length = length;
    }

}
