package com.henna.lopputyo.data;

import java.util.UUID;

public class Course {
    protected String courseName = "";
    protected String courseID = "";
    protected int courseEcts = 0;
    protected String teacher = "";



    public Course(String courseName, int courseEcts, String teacher) {
        this.courseName = courseName;
        this.courseEcts = courseEcts;
        this.teacher = teacher;
        createID();
    }

    protected void createID() {
        this.courseID = UUID.randomUUID().toString(); // Generates a unique ID for every course
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseID() {
        return this.courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public int getCourseEcts() {
        return this.courseEcts;
    }

    public void setCourseEcts(int courseEcts) {
        this.courseEcts = courseEcts;
    }

    public String getTeacher() {
        return this.teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
}
