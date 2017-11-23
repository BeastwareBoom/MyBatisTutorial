package com.ascland.cascade.pojo.discriminator;

/**
 * 男学生健康表
 */
public class MaleHealth {
    private int id;
    private String qlx;//前列腺健康状况
    private int studentId;

    @Override
    public String toString() {
        return "MaleHealth{" +
                "id=" + id +
                ", qlx='" + qlx + '\'' +
                ", studentId=" + studentId +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQlx() {
        return qlx;
    }

    public void setQlx(String qlx) {
        this.qlx = qlx;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}
