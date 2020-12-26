package test.org.bougainvillea.spring5.ioc.factorybean;

import org.bougainvillea.spring5.ioc.collection.Course;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 工厂bean 使用工厂创建bean
 * @author renqiankun
 */
public class MybeanTest {


    @Test
    public void testMybean(){
        ApplicationContext context=new ClassPathXmlApplicationContext("source/ioc/factorybean/factoryBean.xml");
        Course myBean = context.getBean("myBean", Course.class);
        System.err.println(myBean);
    }
}
