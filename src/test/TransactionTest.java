import com.ascland.cascade.pojo.TTeacher;
import com.ascland.cascade.pojo.Teacher;
import com.ascland.cascade.tx.TeacherService;
import org.apache.log4j.BasicConfigurator;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * t_teacher表测试
 */
public class TransactionTest {

    @BeforeClass
    public static void init() {
        //初始化log4j配置
        BasicConfigurator.configure();
    }

    @Test
    public void testSelectTransaction() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        TeacherService service = (TeacherService) ctx.getBean("service");
        TTeacher teacher = service.selectByPrimaryKey(1);
        System.out.println(teacher);
    }

    @Test
    public void testInsertTransaction() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        TeacherService service = (TeacherService) ctx.getBean("service");
        TTeacher record = new TTeacher();
        record.settName("刘焕新9");
        record.settAge("58");
        record.settGender("男");
        int cols = service.insert(record);
        System.out.println("cols = " + cols);
    }
}
