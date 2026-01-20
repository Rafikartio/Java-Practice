package org.example.jdbc;

import java.time.LocalDate;

public class StudentCourses {
    private int id;
    private Student student;
    private Course course;
    private LocalDate enrollDate;
    private String status;

    public StudentCourses(int id, Student student, Course course, LocalDate enrollDate, String status) {
        this.id = id;
        this.student = student;
        this.course = course;
        this.enrollDate = enrollDate;
        this.status = status;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public LocalDate getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(LocalDate enrollDate) {
        this.enrollDate = enrollDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "StudentCourses{" +
                "id=" + id +
                ", student=" + student +
                ", course=" + course +
                ", enrollDate=" + enrollDate +
                ", status='" + status + '\'' +
                '}';
    }
}
