package com.ascland.cascade.pojo;

import org.apache.ibatis.type.Alias;

@Alias("teacher")
public class Teacher {
    private int teacherId;//     INT         NOT NULL AUTO_INCREMENT,
    private String teacherName;//   VARCHAR(20) NOT NULL,
    private String teacherGender;// VARCHAR(2)  NOT NULL,
    private int teacherAge;//    int,

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", teacherGender='" + teacherGender + '\'' +
                ", teacherAge=" + teacherAge +
                '}';
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherGender() {
        return teacherGender;
    }

    public void setTeacherGender(String teacherGender) {
        this.teacherGender = teacherGender;
    }

    public int getTeacherAge() {
        return teacherAge;
    }

    public void setTeacherAge(int teacherAge) {
        this.teacherAge = teacherAge;
    }
}
