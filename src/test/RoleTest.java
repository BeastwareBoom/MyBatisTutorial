import com.ascland.chapter02.Role;
import com.ascland.chapter02.RoleMapper;
import com.ascland.chapter02.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * Created by Asus on 2017/11/16.
 */
public class RoleTest {

    @Test
    public void testInsert() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
            Role role = new Role();
            role.setRoleName("管理员");
            role.setNote("说明");
            mapper.insertRole(role);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }

    }


    @Test
    public void testQuery() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
            Role role = mapper.getRole(1L);
            System.out.println(role);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
