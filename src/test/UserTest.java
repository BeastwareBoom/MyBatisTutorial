import com.ascland.mapping.SqlSessionFactoryUtil;
import com.ascland.mapping.User;
import com.ascland.mapping.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * Created by Asus on 2017/11/19.
 */
public class UserTest {

    @Test
    public void testInsertRole() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = new User();
            user.setUserName("刘宗泽");
            user.setUserRoleId(10007L);
            int column = mapper.insertUser(user);
            System.out.println("column = " + column);
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
