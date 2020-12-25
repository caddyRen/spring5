package test.org.bougainvillea.spring5.ioc;

import org.bougainvillea.spring5.ioc.Emp;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Emptest {

    /**
     * 注入内部属性
     */
    @Test
    public void testShow(){
        ApplicationContext context=new ClassPathXmlApplicationContext("source/ioc/empBean.xml");
        Emp emp = context.getBean("emp", Emp.class);
        emp.show();
    }

    /**
     * 注入内部属性另一种写法，需要get方法，获取到内部bean，然后赋值改变内部bean属性
     */
    @Test
    public void testShow1(){
        ApplicationContext context=new ClassPathXmlApplicationContext("source/ioc/empBean1.xml");
        Emp emp = context.getBean("emp", Emp.class);
        emp.show();
    }

}
