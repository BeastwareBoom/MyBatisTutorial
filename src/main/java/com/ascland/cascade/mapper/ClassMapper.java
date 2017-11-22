package com.ascland.cascade.mapper;

import com.ascland.cascade.pojo.Class;

import java.util.List;

/**
 * Created by Asus on 2017/11/22.
 */
public interface ClassMapper {
    Class getClassStudentMap(int classId);

    Class getClassMap(int classId);
}
