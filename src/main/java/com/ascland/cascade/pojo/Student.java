package com.ascland.cascade.pojo;

import org.apache.ibatis.type.Alias;

import java.util.List;

@Alias("student")
public class Student {
    private int studentId;//     INT         NOT NULL AUTO_INCREMENT,
    private String studentName;//   VARCHAR(20) NOT NULL,
    private String studentGender;// VARCHAR(2)  NOT NULL,
    private int studentAge;//    int,
    private int classId;
    private List<Course> courses;


    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentGender='" + studentGender + '\'' +
                ", studentAge=" + studentAge +
                ", classId=" + classId +
                ", courses=" + courses +
                '}';
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
