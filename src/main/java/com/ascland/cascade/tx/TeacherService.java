package com.ascland.cascade.tx;

import com.ascland.cascade.pojo.TTeacher;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//@Transactional(rollbackFor = Exception.class)
public interface TeacherService {
    int deleteByPrimaryKey(Integer tId);

    //    @Transactional(rollbackFor = Exception.class)
//    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    int insert(TTeacher record) throws ArithmeticException;

    int insertSelective(TTeacher record);

    TTeacher selectByPrimaryKey(Integer tId);

    int updateByPrimaryKeySelective(TTeacher record);

    int updateByPrimaryKey(TTeacher record);
}
