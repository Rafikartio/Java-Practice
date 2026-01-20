package org.example.jdbc;

public class Course {

    private int id;
    private String courseTitle;
    private String courseDuration;
    private Class aClass;

    public Course(int id, String courseTitle, String courseDuration, Class aClass) {
        this.id = id;
        this.courseTitle = courseTitle;
        this.courseDuration = courseDuration;
        this.aClass = aClass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(String courseDuration) {
        this.courseDuration = courseDuration;
    }

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseTitle='" + courseTitle + '\'' +
                ", courseDuration='" + courseDuration + '\'' +
                ", aClass=" + aClass +
                '}';
    }
}
