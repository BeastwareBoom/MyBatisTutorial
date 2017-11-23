package com.ascland.cascade.pojo.discriminator;

import com.ascland.cascade.pojo.Student;

/**
 * 女学生
 */
public class FemaleStudent extends Student {

    private FemaleHealth femaleHealth;

    public FemaleHealth getFemaleHealth() {
        return femaleHealth;
    }

    public void setFemaleHealth(FemaleHealth femaleHealth) {
        this.femaleHealth = femaleHealth;
    }

    @Override
    public String toString() {
        return "FemaleStudent{" +
                "femaleHealth=" + femaleHealth +
                '}';
    }
}
