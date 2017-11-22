package com.ascland.cascade.pojo;

import org.apache.ibatis.type.Alias;

import java.util.List;

@Alias("course")
public class Course {

    private int courseId;//c_id       INT         NOT NULL AUTO_INCREMENT,
    private String courseName;//c_name     VARCHAR(20) NOT NULL,
    private String courseDesc;//c_desc     VARCHAR(100),
    private Teacher teacher;//teacher_id INT         NOT NULL,
    private List<Student> students;//对应多个学生

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseDesc='" + courseDesc + '\'' +
                ", teacher=" + teacher +
                ", students=" + students +
                '}';
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
