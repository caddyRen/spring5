package test.org.bougainvillea.spring5.spring5_new;

import org.bougainvillea.spring5.ioc.annotation.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 使用JUnit4框架测试
 *
 * @author renqiankun
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:source/ioc/annotation/annotation.xml"})
public class JTest4 {

    @Autowired
    UserService userService;

    @Test
    public void testAdd(){
//        ApplicationContext context=new ClassPathXmlApplicationContext("source/ioc/annotation/annotation.xml");
//        UserService userService=context.getBean("userService",UserService.class);
        userService.add();
    }
}
