package test.org.bougainvillea.spring5.spring5_new;

import org.bougainvillea.spring5.spring5_new.LambdaUser;
import org.junit.Test;
import org.springframework.context.support.GenericApplicationContext;

/**
 * 函数式风格
 * @author renqiankun
 */
public class LambdaUserTest {
    @Test
    public void show(){

        GenericApplicationContext context=new GenericApplicationContext();
        context.refresh();
        //指定beanName
//        context.registerBean("user",LambdaUser.class,()->new LambdaUser("咯咯哒"));
//        LambdaUser lambdaUser=context.getBean("user",LambdaUser.class);
        //默认 需要把包类全路径加上
        context.registerBean(LambdaUser.class,()->new LambdaUser("咯咯哒"));
        LambdaUser lambdaUser=(LambdaUser)context.getBean("org.bougainvillea.spring5.spring5_new.LambdaUser");
        lambdaUser.show();
    }
}
