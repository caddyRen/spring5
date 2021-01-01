package test.org.bougainvillea.spring5.spring5_new;

import org.bougainvillea.spring5.ioc.annotation.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * 使用JUnit5框架测试
 *
 * @author renqiankun
 */
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(locations = {"classpath:source/ioc/annotation/annotation.xml"})

//复合注解替换上面两个注解
@SpringJUnitConfig(locations = {"classpath:source/ioc/annotation/annotation.xml"})
public class JTest5 {


    @Autowired
    UserService userService;

    @Test
    public void testAdd(){
        System.out.println("Spring5+JUnit5");
//        ApplicationContext context=new ClassPathXmlApplicationContext("source/ioc/annotation/annotation.xml");
//        UserService userService=context.getBean("userService",UserService.class);
        userService.add();
    }
}
