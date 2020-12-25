package test.org.bougainvillea.spring5.ioc;

import org.bougainvillea.spring5.ioc.Book;
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
}
