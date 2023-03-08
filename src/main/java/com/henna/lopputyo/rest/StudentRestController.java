package com.henna.lopputyo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.henna.lopputyo.data.Student;
import com.henna.lopputyo.service.StudentService;

@RestController
public class StudentRestController {

    StudentService sService;
    // all mappings have been tested using thunderclient

    @Autowired
    public StudentRestController(StudentService sService) {
        this.sService = sService;
    }

    // add one student --> works
    @PostMapping("/addstudent")
    public Student addStudent(@RequestBody Student student) {
        sService.addStudent(student);
        return student;
    }

    // get all students --> works
    @GetMapping("/getstudents")
    public List<Student> getStudents() {
        return sService.getStudents();
    }

    // get one student based on the keyword (can be name or ID) --> works
    @GetMapping("getstudent/{keyword}")
    public Student getStudent(@PathVariable String keyword) {
        return sService.getStudent(keyword);
    }

    // enroll student to a course --> works
    @PostMapping("/enroll/{studentID}/{courseID}")
    public String enrollStudent(@PathVariable String studentID, @PathVariable String courseID) {
        return sService.enroll(studentID, courseID);
    }

    // delete student based on the keyword (can be name or id) --> works
    @DeleteMapping("/deletestudent/{keyword}")
    public String deleteStudent(@PathVariable String keyword) {
        return sService.deleteStudent(keyword);
    }

    //update student based on the keyword (can be name or id) --> works 
    @PutMapping("/updatestudent/{keyword}")
    public Student updateStudent(@PathVariable String keyword, @RequestBody Student student) {
        return sService.updateStudent(keyword, student);
    }

}
