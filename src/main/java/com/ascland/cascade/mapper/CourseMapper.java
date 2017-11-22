package com.ascland.cascade.mapper;

import com.ascland.cascade.pojo.Course;

/**
 * Created by Asus on 2017/11/22.
 */
public interface CourseMapper {

    Course getCourseMap(Course course);

    Course getCourseStudentMap(int courseId);
}
