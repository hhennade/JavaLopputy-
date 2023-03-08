package com.henna.lopputyo.data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Student {
    private String name;
    private int age;
    private String studentID;
    private int ects;
    private List<String> courses = new ArrayList<>();

    public Student(String name, int age, int ects) {
        this.name = name;
        this.age = age;
        this.ects = ects;
        this.studentID = UUID.randomUUID().toString(); // Generates a unique ID for every student
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStudentID() {
        return this.studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public int getEcts() {
        return this.ects;
    }

    public void setEcts(int ects) {
        this.ects = ects;
    }

    public List<String> getCourses() {
        return this.courses;

    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    public void addCourse(String course) {
        this.courses.add(course);
    }
}
