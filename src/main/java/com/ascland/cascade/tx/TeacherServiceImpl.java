package com.ascland.cascade.tx;

import com.ascland.cascade.mapper.TTeacherMapper;
import com.ascland.cascade.pojo.TTeacher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

//除ArithmeticException之外的异常均会回滚
@Transactional(rollbackFor = Throwable.class
        , noRollbackFor = ArithmeticException.class)
@Service("service")
public class TeacherServiceImpl implements TeacherService {

    @Resource
    private TTeacherMapper mapper;

    public int deleteByPrimaryKey(Integer tId) {
        return mapper.deleteByPrimaryKey(tId);
    }

    /**
     * 无论是否try，不影响回滚
     *
     * @param record
     * @return
     */
//    @Transactional(rollbackFor = Exception.class)
    public int insert(TTeacher record) {
        int r = mapper.insert(record);
//        try {
//            r = mapper.insert(record);
        int i = 1 / 0;
//        } catch (ArithmeticException e) {
//            throw new RuntimeException(e);
//        }
        return r;
    }

    public int insertSelective(TTeacher record) {
        return mapper.insert(record);
    }

    public TTeacher selectByPrimaryKey(Integer tId) {
        return mapper.selectByPrimaryKey(tId);
    }

    public int updateByPrimaryKeySelective(TTeacher record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(TTeacher record) {
        return updateByPrimaryKey(record);
    }
}
