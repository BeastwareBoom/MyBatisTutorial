import com.ascland.mapping.SqlSessionFactoryUtil;
import com.ascland.mapping.User;
import com.ascland.mapping.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.BasicConfigurator;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Asus on 2017/11/19.
 */
public class UserTest {

    @BeforeClass
    public static void init() {
        //初始化log4j配置
        BasicConfigurator.configure();
    }


    @Test
    public void testGetUserRole() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User userRole = mapper.getUserRole(1L);
            System.out.println(userRole);
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
