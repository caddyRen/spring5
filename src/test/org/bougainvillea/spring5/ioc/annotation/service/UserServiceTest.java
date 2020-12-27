package test.org.bougainvillea.spring5.ioc.annotation.service;

import org.bougainvillea.spring5.ioc.annotation.config.SpringConfig;
import org.bougainvillea.spring5.ioc.annotation.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author renqiankun
 */
public class UserServiceTest {

    /**
     * 引入context名称空间，扫描注解
     */
    @Test
    public void testAdd(){
        ApplicationContext context=new ClassPathXmlApplicationContext("source/ioc/annotation/annotation.xml");
        UserService userService=context.getBean("userService",UserService.class);
        userService.add();
    }

    /**
     * 完全基于注解，扫描注解 等价于springboot
     */
    @Test
    public void test(){
        /**
         * 加载配置类
         */
        ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);

        UserService userService=context.getBean("userService",UserService.class);
        userService.add();
    }
}
