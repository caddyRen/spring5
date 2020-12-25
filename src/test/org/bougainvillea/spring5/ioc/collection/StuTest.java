package test.org.bougainvillea.spring5.ioc.collection;

import org.bougainvillea.spring5.ioc.collection.Stu;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 集合注入
 */
public class StuTest {
    @Test
    public void testShow(){
        ApplicationContext context=new ClassPathXmlApplicationContext("source/ioc/collection/stuBean.xml");
        Stu stu=context.getBean("stu", Stu.class);
        stu.show();
    }
}
