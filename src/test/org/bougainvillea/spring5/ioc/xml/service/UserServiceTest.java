package test.org.bougainvillea.spring5.ioc.xml.service;

import org.bougainvillea.spring5.ioc.xml.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author renqiankun
 */
public class UserServiceTest {

    @Test
    public void testAdd(){
        ApplicationContext context=new ClassPathXmlApplicationContext("source/ioc/xml/service/userServiceBean.xml");
        UserService userService=context.getBean("userService",UserService.class);
        userService.add();
    }
}
