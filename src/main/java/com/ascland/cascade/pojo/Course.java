package com.ascland.cascade.pojo;

import org.apache.ibatis.type.Alias;

import java.util.List;

@Alias("course")
public class Course {

    private int id;//c_id       INT         NOT NULL AUTO_INCREMENT,
    private String name;//c_name     VARCHAR(20) NOT NULL,
    private String desc;//c_desc     VARCHAR(100),
    private Teacher teacher;//teacher_id INT         NOT NULL,
    private List<Student> students;//对应多个学生

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
