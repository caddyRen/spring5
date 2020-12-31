package test.org.bougainvillea.spring5.jdbc.transaction;

import org.bougainvillea.spring5.jdbc.service.transaction.ServiceImpl;
import org.bougainvillea.spring5.jdbc.service.transaction.xml.ServiceImpl2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 事务
 * @author renqiankun
 */
public class ServiceTest {

    @Test
    public void age(){
        ApplicationContext context=new ClassPathXmlApplicationContext("source/jdbc/datasource.xml");
        ServiceImpl serviceImpl = context.getBean("serviceImpl", ServiceImpl.class);
        serviceImpl.age(1,2,1);
    }
    @Test
    public void ageXml(){
        ApplicationContext context=new ClassPathXmlApplicationContext("source/jdbc/xml/datasource.xml");
        ServiceImpl2 serviceImpl = context.getBean("serviceImpl", ServiceImpl2.class);
        serviceImpl.age(1,2,1);
    }
}
