package com.ascland.cascade.pojo.discriminator;

/**
 * 男学生健康表
 */
public class FemaleHealth {
    private int id;
    private String zg;//子宫健康状况
    private int studentId;

    @Override
    public String toString() {
        return "FemaleHealth{" +
                "id=" + id +
                ", zg='" + zg + '\'' +
                ", studentId=" + studentId +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getZg() {
        return zg;
    }

    public void setZg(String zg) {
        this.zg = zg;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}
