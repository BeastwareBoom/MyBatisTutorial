package com.ascland.cascade.pojo;

import com.ascland.cascade.pojo.Student;
import org.apache.ibatis.type.Alias;

import java.util.List;

/**
 * 班级和学生一对多
 */
@Alias("class")
public class Class {
    private int classId;
    private String className;
    private List<Student> students;

    @Override
    public String toString() {
        return "Class{" +
                "classId=" + classId +
                ", className='" + className + '\'' +
                ", students=" + students +
                '}';
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }


    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
