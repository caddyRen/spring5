package test.org.bougainvillea.spring5.jdbc;

import org.bougainvillea.spring5.jdbc.dao.UserDao;
import org.bougainvillea.spring5.jdbc.po.User;
import org.bougainvillea.spring5.jdbc.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author renqiankun
 */
public class UserServiceTest {

    @Test
    public void testInsert(){
        ApplicationContext context=new ClassPathXmlApplicationContext("source/jdbc/dataSource.xml");
        UserService userService = context.getBean("userServiceImpl", UserService.class);
        User user=context.getBean("user",User.class);
        int insert = userService.insert(user);
        Assert.assertSame(1,insert);
    }
    @Test
    public void testBatchInsert(){
        ApplicationContext context=new ClassPathXmlApplicationContext("source/jdbc/dataSource.xml");
        UserDao userDao = context.getBean("userDaoImpl", UserDao.class);
        List<User> users=new ArrayList<>();
        User user = new User(2, "caddy", 11);
        User user1 = new User(3, "jack", 12);
        User user2 = new User(4, "jerry", 18);
        users.add(user);
        users.add(user1);
        users.add(user2);
        userDao.batchInsert(users);
    }

    @Test
    public void testUpdate(){
        ApplicationContext context=new ClassPathXmlApplicationContext("source/jdbc/dataSource.xml");
        UserService userService = context.getBean("userServiceImpl", UserService.class);
        User user=context.getBean("user",User.class);
        user.setAge(20);
        int update = userService.update(user.getId(),user);
        Assert.assertSame(1,update);
    }
    @Test
    public void testBatchUpdate(){
        ApplicationContext context=new ClassPathXmlApplicationContext("source/jdbc/dataSource.xml");
        UserDao userDao = context.getBean("userDaoImpl", UserDao.class);
        List<User> users=new ArrayList<>();
        User user0 = new User(1, "李二狗", 10);
        User user = new User(2, "caddy1", 12);
        User user1 = new User(3, "jack1", 13);
        User user2 = new User(4, "jerry1", 20);
        users.add(user);
        users.add(user0);
        users.add(user1);
        users.add(user2);
        userDao.batchUpdate(1,users);
    }

    @Test
    public void testDelete(){
        ApplicationContext context=new ClassPathXmlApplicationContext("source/jdbc/dataSource.xml");
        UserService userService = context.getBean("userServiceImpl", UserService.class);
        User user=context.getBean("user",User.class);
        int delete = userService.delete(user.getId());
        Assert.assertSame(1,delete);
    }

    @Test
    public void testBatchDelete(){
        ApplicationContext context=new ClassPathXmlApplicationContext("source/jdbc/dataSource.xml");
        UserDao userDao = context.getBean("userDaoImpl", UserDao.class);
        userDao.batchDelete(new int[]{2,3,4});
    }

    @Test
    public void testSelect(){
        ApplicationContext context=new ClassPathXmlApplicationContext("source/jdbc/dataSource.xml");
        UserService userService = context.getBean("userServiceImpl", UserService.class);
        User user=context.getBean("user",User.class);
        User select = userService.select(user.getId());
        Assert.assertEquals("User{id=1, name='李二狗', age=10}",select.toString());
        System.out.println(select.toString());
    }


    @Test
    public void testSelect2(){
        ApplicationContext context=new ClassPathXmlApplicationContext("source/jdbc/dataSource.xml");
        UserService userService = context.getBean("userServiceImpl", UserService.class);
        User user=context.getBean("user",User.class);
        User select = userService.select2(user.getId());
        Assert.assertEquals("User{id=1, name='李二狗', age=10}",select.toString());
    }

    @Test
    public void testSelectList(){
        ApplicationContext context=new ClassPathXmlApplicationContext("source/jdbc/dataSource.xml");
        UserDao userDao = context.getBean("userDaoImpl", UserDao.class);
        System.out.println(userDao.selectList(1));
    }
}
