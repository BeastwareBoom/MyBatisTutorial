package com.ascland.cascade.pojo;

import org.apache.ibatis.type.Alias;

@Alias("teacher")
public class Teacher {
    private int id;//     INT         NOT NULL AUTO_INCREMENT,
    private String name;//   VARCHAR(20) NOT NULL,
    private String gender;// VARCHAR(2)  NOT NULL,
    private int age;//    int,

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
