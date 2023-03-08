package com.henna.lopputyo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.henna.lopputyo.data.Student;

@Service
public class StudentService {
    private List<Student> students = new ArrayList<>();

    // add one student
    public void addStudent(Student student) {
        try{
            if (student.getName().isEmpty() || student.getName().isBlank()) {
                throw new IllegalArgumentException("Name cannot be empty");
            }
            if (student.getAge() < 18) {
                throw new IllegalArgumentException("Student must be 18 years old or older to register ");
            }
            if (student.getEcts() < 0) {
                throw new IllegalArgumentException("ECTS cannot be negative");
            }
            students.add(student);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    // get all students
    public List<Student> getStudents() {
        if (this.students.isEmpty()) {
            return null;
        } else {
            return this.students;
        }
    }

    // get one student based on the keyword (can be name or ID)
    public Student getStudent(String keyword) {
        for (Student student : students) {
            if (student.getName().contains(keyword)) {
                return student;
            }
            if (student.getStudentID().contains(keyword)) {
                return student;
            }
        }
            return null;
    }

    // enroll student to a course, works best if the user knows the unique id of the
    // student and course
    public String enroll(String studentID, String courseID) {
        getStudents();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentID().equals(studentID)) {
                students.get(i).addCourse(courseID);
                return "Student enrolled to course";
            }
        }
        return "Check your student ID or course ID";
    }

    //removes the student based on the keyword
    public String deleteStudent(String keyword)
    {
        for(Student student : students){
            if(student.getName().contains(keyword)){
                students.remove(student);
                return "Student removed based on name";
            }
            if(student.getStudentID().contains(keyword)){
                students.remove(student);
                return "Student removed based on ID";
            }
        }
        return "Did not found student based on the keyword";
    }

    //update student based on the keyword (best if used part of the id)
    public Student updateStudent(String keyword, Student updatedStudent){
        Student student = getStudent(keyword);
        if(student != null){
            student.setName(updatedStudent.getName());
            student.setAge(updatedStudent.getAge());
            student.setEcts(updatedStudent.getEcts());
            return student;
        }
        else{
            return null;
        }
    }
}