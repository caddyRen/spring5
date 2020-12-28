package test.org.bougainvillea.spring5.aop.annotation;

import org.bougainvillea.spring5.aop.annotation.AOPConfig;
import org.bougainvillea.spring5.aop.annotation.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * aop测试
 * @author renqiankun
 */
public class UserDaoTest {

    @Test
    public void testProxy(){
        ApplicationContext context=new ClassPathXmlApplicationContext("source/aop/annotation/annotation.xml");
        UserDao userDao = context.getBean("userDao", UserDao.class);
        userDao.add();
        userDao.update("1");
    }

    /**
     * 完全基于注解
     */
    @Test
    public void testProxy2(){
        ApplicationContext context=new AnnotationConfigApplicationContext(AOPConfig.class);
        UserDao userDao = context.getBean("userDao", UserDao.class);
        System.out.println("完全基于注解");

        userDao.add();
        userDao.update("1");
    }


}
