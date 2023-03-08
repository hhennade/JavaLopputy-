package com.henna.lopputyo.data;

public class OnlineCourse extends Course {
    private String courseURL = ""; // URL to the course
    private String coursePlatform = ""; // Platform the course is on (Zoom)


    public OnlineCourse(String courseURL, String coursePlatform) {
        super("", 0, "");
        this.courseURL = courseURL;
        this.coursePlatform = coursePlatform;
        createID();
    }

    public String getCourseURL() {
        return this.courseURL;
    }

    public void setCourseURL(String courseURL) {
        this.courseURL = courseURL;
    }

    public String getCoursePlatform() {
        return this.coursePlatform;
    }

    public void setCoursePlatform(String coursePlatform) {
        this.coursePlatform = coursePlatform;
    }

}
