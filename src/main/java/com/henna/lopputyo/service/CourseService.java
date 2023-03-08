package com.henna.lopputyo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.henna.lopputyo.data.ClassCourse;
import com.henna.lopputyo.data.Course;
import com.henna.lopputyo.data.OnlineCourse;

@Service
public class CourseService {
    private List<OnlineCourse> onlineCourses = new ArrayList<>();
    private List<ClassCourse> classCourses = new ArrayList<>();

    // add online course
    public void addOnlineCourse(OnlineCourse ocourse) {
        try {
            if (ocourse.getCourseName().isEmpty() || ocourse.getCourseName().isBlank()) {
                throw new IllegalArgumentException("Name cannot be empty");
            }
            if (ocourse.getTeacher().isEmpty() || ocourse.getTeacher().isBlank()) {
                throw new IllegalArgumentException("You must have a teacher");
            }
            if (ocourse.getCourseEcts() < 0) {
                throw new IllegalArgumentException("ECTS cannot be negative");
            }
            if (ocourse.getCourseURL().isEmpty() || ocourse.getCourseURL().isBlank()) {
                throw new IllegalArgumentException("Must enter URL");
            }
            if (ocourse.getCoursePlatform().isEmpty() || ocourse.getCoursePlatform().isBlank()) {
                throw new IllegalArgumentException("Must enter Course Platform");
            }
            if (ocourse.getCourseURL().isEmpty() || ocourse.getCourseURL().isBlank()) {
                throw new IllegalArgumentException("Must enter URL");
            }
            if (ocourse.getCoursePlatform().isEmpty() || ocourse.getCoursePlatform().isBlank()) {
                throw new IllegalArgumentException("Must enter Course Platform");
            }
            onlineCourses.add(ocourse);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    // add classroom course
    public void addClassCourse(ClassCourse cCourse) {
        try {
            if (cCourse.getCourseName().isEmpty() || cCourse.getCourseName().isBlank()) {
                throw new IllegalArgumentException("Name cannot be empty");
            }
            if (cCourse.getTeacher().isEmpty() || cCourse.getTeacher().isBlank()) {
                throw new IllegalArgumentException("You must have a teacher");
            }
            if (cCourse.getCourseEcts() < 0) {
                throw new IllegalArgumentException("ECTS cannot be negative");
            }
            if (cCourse.getClassRoom().isEmpty() || cCourse.getClassRoom().isBlank()) {
                throw new IllegalArgumentException("Must enter classroom");
            }
            if (cCourse.getDay().isEmpty() || cCourse.getDay().isBlank()) {
                throw new IllegalArgumentException("Must enter day");
            }
            if (cCourse.getTime().isEmpty() || cCourse.getTime().isBlank()) {
                throw new IllegalArgumentException("Must enter time");
            }
            if(cCourse.getLength() <= 0 || cCourse.getLength() > 24.0)
            {
                throw new IllegalArgumentException("Length must be between 0.01 - 24.0");
            }
            classCourses.add(cCourse);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    // get all online courses
    public List<OnlineCourse> getOnlineCourses() {
        if (this.onlineCourses.isEmpty())
            return null;
        else {
            return this.onlineCourses;
        }
    }

    // get all classroom courses
    public List<ClassCourse> getClassCourses() {
        if (this.classCourses.isEmpty())
            return null;
        else {
            return this.classCourses;
        }
    }

    // get online course based on keyword (can be name or id)
    public OnlineCourse getOnlineCourse(String keyword) {
        for (OnlineCourse onlineCourse : onlineCourses) {
            if (onlineCourse.getCourseName().contains(keyword)) {
                return onlineCourse;
            }
            if (onlineCourse.getCourseID().contains(keyword)) {
                return onlineCourse;
            }
        }
        return null;

    }

    // get classroom course based on keyword (can be name or id)
    public ClassCourse getClassCourse(String keyword) {
        for (ClassCourse classCourse : classCourses) {
            if (classCourse.getCourseName().contains(keyword)) {
                return classCourse;
            }
            if (classCourse.getCourseID().contains(keyword)) {
                return classCourse;
            }
        }
        return null;
    }

    // remove online course
    public String deleteOnlineCourse(String keyword) {
        for (Course onlineCourse : onlineCourses) {
            if (onlineCourse.getCourseName().contains(keyword)) {
                onlineCourses.remove(onlineCourse);
                return "Online course removed based on name";
            }
            if (onlineCourse.getCourseID().contains(keyword)) {
                onlineCourses.remove(onlineCourse);
                return "Online course removed based on ID";
            }
        }
        return "Did not found online course based on the keyword";
    }

    // remove classcourse
    public String deleteClassCourse(String keyword) {
        for (Course classCourse : classCourses) {
            if (classCourse.getCourseName().contains(keyword)) {
                classCourses.remove(classCourse);
                return "Online course removed based on name";
            }
            if (classCourse.getCourseID().contains(keyword)) {
                classCourses.remove(classCourse);
                return "Online course removed based on ID";
            }
        }
        return "Did not found class course based on the keyword";
    }

    // update online course
    public OnlineCourse updateOnlineCourse(String keyword, OnlineCourse updatedOnline) {
        OnlineCourse onlineCourse = getOnlineCourse(keyword);
        if (onlineCourse != null) {
            onlineCourse.setCourseName(updatedOnline.getCourseName());
            onlineCourse.setCourseEcts(updatedOnline.getCourseEcts());
            onlineCourse.setTeacher(updatedOnline.getTeacher());
            onlineCourse.setCourseURL(updatedOnline.getCourseURL());
            onlineCourse.setCoursePlatform(updatedOnline.getCoursePlatform());
            return onlineCourse;
        }
        return null;
    }

    // update class course
    public ClassCourse updateClassCourse(String keyword, ClassCourse updatedClassCourse) {
        ClassCourse classCourse = getClassCourse(keyword);
        if (classCourse != null) {
            classCourse.setCourseName(updatedClassCourse.getCourseName());
            classCourse.setCourseEcts(updatedClassCourse.getCourseEcts());
            classCourse.setTeacher(updatedClassCourse.getTeacher());
            classCourse.setClassRoom(updatedClassCourse.getClassRoom());
            classCourse.setDay(updatedClassCourse.getDay());
            classCourse.setTime(updatedClassCourse.getTime());
            classCourse.setLength(updatedClassCourse.getLength());
            return classCourse;
        }
        return null;
    }

}
