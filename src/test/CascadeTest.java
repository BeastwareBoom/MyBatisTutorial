import com.ascland.cascade.mapper.ClassMapper;
import com.ascland.cascade.mapper.CourseMapper;
import com.ascland.cascade.mapper.StudentMapper;
import com.ascland.cascade.pojo.Class;
import com.ascland.cascade.pojo.Course;
import com.ascland.cascade.pojo.Student;
import com.ascland.mapping.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.BasicConfigurator;
import org.junit.BeforeClass;
import org.junit.Test;


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
            Course course = new Course();
            course.setCourseId(1);
//            course.setCourseName("数学");
            //查询课程老师
            Course courseMap = mapper.getCourseMap(course);
            System.out.println(courseMap);

            //查询课程+学生
//            Course courseStudentMap = mapper.getCourseStudentMap(1);
//            System.out.println(courseStudentMap);
//            List<Student> students = courseStudentMap.getStudents();
//            for (int i = 0; i < students.size(); i++) {
//                Student student = students.get(i);
//                System.out.println(student);
//            }
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

    /**
     * 测试懒加载
     */
    @Test
    public void testGetClass() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
//            Class classStudentMap = mapper.getClassStudentMap(1);
            Class classStudentMap = mapper.getClassStudentMap2(3);
            Class classStudentMap2 = mapper.getClassStudentMap2(3);
//            System.out.println(classStudentMap);
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
    public void testGetStudent() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            Student student = mapper.getStudentById(1);
            System.out.println(student.getStudentName() + "：" + student.getStudentGender());
            System.out.println(student);
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
