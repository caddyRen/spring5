package test.org.bougainvillea.spring5.ioc.xml.collection;

import org.bougainvillea.spring5.ioc.xml.collection.Stu;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 集合注入
 * @author renqiankun
 */
public class StuTest {
    @Test
    public void testShow(){
        ApplicationContext context=new ClassPathXmlApplicationContext("source/ioc/xml/collection/stuBean.xml");
        Stu stu=context.getBean("stu", Stu.class);
        stu.show();
    }
}
