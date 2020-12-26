package test.org.bougainvillea.spring5.ioc.xml.lifecycle;

import org.bougainvillea.spring5.ioc.xml.Book;
import org.bougainvillea.spring5.ioc.xml.lifecycle.Order;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 生命周期
 * @author renqiankun
 */
public class OrderTest {

    @Test
    public void testLifeCycle(){
        //ApplicationContext没有close入口
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("source/ioc/xml/lifecycle/order.xml");
        System.out.println("第四步：获取创建的bean");
        Order order = context.getBean("order", Order.class);
        System.out.println(order);
        //默认将当前配置文件内的所有bean都配置一个后置处理器
        Book book=context.getBean("book", Book.class);
        System.out.println(book);
        //手动关闭ioc容器
        context.close();

    }
}
