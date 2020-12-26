package test.org.bougainvillea.spring5.ioc.xml.autowire;

import org.bougainvillea.spring5.ioc.xml.autowire.Emp;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 自动装配
 * @author renqiankun
 */
public class EmpTest {

    @Test
    public void testAutowireByName(){
        ApplicationContext context=new ClassPathXmlApplicationContext("source/ioc/xml/autowire/autowireByName.xml");
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);
    }

    /**
     * 自动装配时 同一文件中不能定义相同类型的Bean
     */
    @Test
    public void testAutowireByType(){
        ApplicationContext context=new ClassPathXmlApplicationContext("source/ioc/xml/autowire/autowireByType.xml");
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);
    }


}
