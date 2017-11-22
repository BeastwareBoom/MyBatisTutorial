import com.ascland.cascade.pojo.Class;
import com.ascland.cascade.mapper.ClassMapper;
import com.ascland.cascade.mapper.CourseMapper;
import com.ascland.cascade.pojo.Course;
import com.ascland.chapter02.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.BasicConfigurator;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

/**
 * Created by Asus on 2017/11/22.
 */
public class CascadeTest {
    @BeforeClass
    public static void init() {
        //初始化log4j配置
        BasicConfigurator.configure();
    }

    @Test
    public void testGetCourse() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
//            ClassMapper studentMapper = sqlSession.getMapper(ClassMapper.class);
//            Student studentMap = studentMapper.getStudentCourseMap(1);
//            System.out.println(studentMap);
            Course course = new Course();
            course.setCourseId(1);
//            course.setCourseName("数学");
//            Course courseMap = mapper.getCourseMap(course);
            Course courseStudentMap = mapper.getCourseStudentMap(1);
//            System.out.println(courseMap);
            System.out.println(courseStudentMap);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (sqlSession != null) {
                sqlSession.rollback();
            }
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    @Test
    public void testGetClass() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
            Class classStudentMap = mapper.getClassStudentMap(1);
//            Class classStudentMap = mapper.getClassMap(1);
            System.out.println(classStudentMap);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (sqlSession != null) {
                sqlSession.rollback();
            }
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
