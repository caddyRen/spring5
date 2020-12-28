package test.org.bougainvillea.spring5.aop.xml;

import org.bougainvillea.spring5.aop.xml.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * aop测试
 * @author renqiankun
 */
public class UserDaoTest {

    @Test
    public void testProxy(){
        ApplicationContext context=new ClassPathXmlApplicationContext("source/aop/xml/aop.xml");
        UserDao userDao = context.getBean("userDao", UserDao.class);
        userDao.add();
        userDao.update("1");
    }
}
