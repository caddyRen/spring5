package test.org.bougainvillea.spring5.ioc;

import org.bougainvillea.spring5.ioc.Book;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author renqiankun
 */
public class BookTest {
    @Test
    public void testShow(){
        ApplicationContext context=new ClassPathXmlApplicationContext("source/ioc/bookBean.xml");
        Book book=context.getBean("book", Book.class);
        book.show();
    }

    /**
     * bean作用域
     * 单例 多例
     */
    @Test
    public void testScop(){
        ApplicationContext context=new ClassPathXmlApplicationContext("source/ioc/bookBean.xml");
        Book book=context.getBean("book", Book.class);
        Book book1=context.getBean("book", Book.class);
        Assert.assertEquals(book,book1);
    }
}
