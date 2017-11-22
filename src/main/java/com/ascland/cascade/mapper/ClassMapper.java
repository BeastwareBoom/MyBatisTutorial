package com.ascland.cascade.mapper;

import com.ascland.cascade.pojo.Class;

import java.util.List;

/**
 * Created by Asus on 2017/11/22.
 */
public interface ClassMapper {

    /**
     * 一对多查询class-student
     *
     * @param classId
     * @return
     */
    Class getClassStudentMap(int classId);

    /**
     * 一对多查询，嵌套select
     *
     * @param classId
     * @return
     */
    Class getClassStudentMap2(int classId);
}
