package com.ascland.cascade.pojo;

/**
 * 保存Student和Course多对多关系的中间表
 */
public class StudentCourseKey {

    private Student student;
    private Course course;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
