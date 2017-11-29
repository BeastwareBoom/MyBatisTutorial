package com.ascland.cascade.mapper;

import com.ascland.cascade.pojo.TTeacher;

public interface TTeacherMapper {

    int deleteByPrimaryKey(Integer tId);

    int insert(TTeacher record);

    int insertSelective(TTeacher record);

    TTeacher selectByPrimaryKey(Integer tId);

    int updateByPrimaryKeySelective(TTeacher record);

    int updateByPrimaryKey(TTeacher record);
}