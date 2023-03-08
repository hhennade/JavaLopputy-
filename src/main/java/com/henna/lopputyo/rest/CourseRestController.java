package com.henna.lopputyo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.henna.lopputyo.data.ClassCourse;
import com.henna.lopputyo.data.Course;
import com.henna.lopputyo.data.OnlineCourse;
import com.henna.lopputyo.service.CourseService;

@RestController
public class CourseRestController {

    CourseService cService;

    // all mappings have been tested using thunderclient
    @Autowired
    public CourseRestController(CourseService cService) {
        this.cService = cService;
    }

    // add online course --> works
    @PostMapping("/addonlinecourse")
    public OnlineCourse addOnlineCourse(@RequestBody OnlineCourse onlineCourse) {
        cService.addOnlineCourse(onlineCourse);
        return onlineCourse;
    }

    // add classroom course --> works
    @PostMapping("/addclasscourse")
    public ClassCourse addClassCourse(@RequestBody ClassCourse classCourse) {
        cService.addClassCourse(classCourse);
        return classCourse;
    }

    // get all online courses --> works
    @GetMapping("/getonlinecourses")
    public List<OnlineCourse> getOnlineCourses() {
        return cService.getOnlineCourses();
    }

    // get all classroom courses --> works
    @GetMapping("/getclasscourses")
    public List<ClassCourse> getClassCourses() {
        return cService.getClassCourses();
    }

    // get onlinecourse based on keyword (can be name or id) --> works
    @GetMapping("/getonlinecourses/{keyword}")
    public Course getOnlineCourse(@PathVariable String keyword) {
        return cService.getOnlineCourse(keyword);
    }

    // get classcourse based on keyword (can be name or id) --> works
    @GetMapping("/getclasscourses/{keyword}")
    public Course getClassCourse(@PathVariable String keyword) {
        return cService.getClassCourse(keyword);
    }

    // remove onlinecourse --> works
    @DeleteMapping("/deleteonline/{keyword}")
    public String deleteOnlineCourse(@PathVariable String keyword) {
        return cService.deleteOnlineCourse(keyword);
    }

    // remove classroomcourse --> works
    @DeleteMapping("/deleteclass/{keyword}")
    public String deleteClassCourse(@PathVariable String keyword) {
        return cService.deleteClassCourse(keyword);
    }

    //update onlinecourse --> works
    @PutMapping ("/updateonline/{keyword}")
    public OnlineCourse updateOnlineCourse(@PathVariable String keyword, @RequestBody OnlineCourse onlineCourse) {
        return cService.updateOnlineCourse(keyword, onlineCourse);
    }

    //update classroomcourse --> works
    @PutMapping ("/updateclass/{keyword}")
    public ClassCourse updateClassCourse(@PathVariable String keyword, @RequestBody ClassCourse classCourse) {
        return cService.updateClassCourse(keyword, classCourse);
    }
}
