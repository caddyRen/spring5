package test.org.bougainvillea.spring5.ioc.annotation;

import org.bougainvillea.spring5.ioc.annotation.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * junit test
 * @author renqiankun
 */
public class UserTest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("source/ioc/annotation/annotation.xml");
        User user = context.getBean("user",User.class);
        System.out.println(user);
    }
}
