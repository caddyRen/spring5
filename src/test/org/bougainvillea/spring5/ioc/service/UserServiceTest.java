package test.org.bougainvillea.spring5.ioc.service;

import org.bougainvillea.spring5.ioc.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author renqiankun
 */
public class UserServiceTest {

    @Test
    public void testAdd(){
        ApplicationContext context=new ClassPathXmlApplicationContext("source/ioc/service/userServiceBean.xml");
        UserService userService=context.getBean("userService",UserService.class);
        userService.add();
    }
}
