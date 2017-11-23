package com.ascland.cascade.pojo.discriminator;

import com.ascland.cascade.pojo.Student;
import org.apache.ibatis.type.Alias;

/**
 * 男学生
 */
public class MaleStudent extends Student {

    private MaleHealth maleHealth;

    public MaleHealth getMaleHealth() {
        return maleHealth;
    }

    public void setMaleHealth(MaleHealth maleHealth) {
        this.maleHealth = maleHealth;
    }

    @Override
    public String toString() {
        return "MaleStudent{" +
                "maleHealth=" + maleHealth +
                '}';
    }
}
