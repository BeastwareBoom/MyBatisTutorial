import com.ascland.chapter02.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * Created by Asus on 2017/11/16.
 */
public class RoleTest {

    @Test
    public void test() {
        SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
    }
}
