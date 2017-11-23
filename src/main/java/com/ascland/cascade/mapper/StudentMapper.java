package com.ascland.cascade.mapper;

import com.ascland.cascade.pojo.Student;

/**
 * discriminator鉴别器测试
 */
public interface StudentMapper {

    Student getStudentById(int studentId);

}
