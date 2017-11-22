package com.ascland.cascade.mapper;

import com.ascland.cascade.pojo.Course;

/**
 * 课程表的接口
 */
public interface CourseMapper {

    /**
     * 一对一查询course-teacher
     *
     * @param course
     * @return
     */
    Course getCourseMap(Course course);

    /**
     * 多对多查询course-student
     *
     * @param courseId
     * @return
     */
    Course getCourseStudentMap(int courseId);
}
