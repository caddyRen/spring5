package test.org.bougainvillea.spring5.ioc.annotation.service;

import org.bougainvillea.spring5.ioc.annotation.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author renqiankun
 */
public class UserServiceTest {

    @Test
    public void testAdd(){
        ApplicationContext context=new ClassPathXmlApplicationContext("source/ioc/annotation/annotation.xml");
        UserService userService=context.getBean("userService",UserService.class);
        userService.add();
    }
}
