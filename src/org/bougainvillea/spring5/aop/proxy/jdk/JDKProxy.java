package org.bougainvillea.spring5.aop.proxy.jdk;

import org.bougainvillea.spring5.aop.proxy.jdk.dao.UserDao;
import org.bougainvillea.spring5.aop.proxy.jdk.dao.impl.UserDaoImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * jdk动态代理
 * @author renqiankun
 */
public class JDKProxy {
    public static void main(String[] args) {
        //待增强类实现的接口
        Class[] interfaces={UserDao.class};
        //使用Proxy类下的newProxyInstance方法创建UserDao接口实现类的代理对象，增强 UserDao接口实现类 被代理方法
        UserDao userdao =(UserDao) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new MyInvocationHandler(new UserDaoImpl()));
        int add = userdao.add(1, 2);
        System.out.println(add);
        String update = userdao.update("给我加上翅膀");
        System.out.println(update);
    }
}

/**
 * 代理对像
 * @author renqiankun
 */
class MyInvocationHandler implements InvocationHandler{
    //把被代理对象传入代理对象
    private Object obj;

    public MyInvocationHandler(Object obj) {
        this.obj=obj;
    }

    /**
     *
     * @param proxy 代理对象
     * @param method 被代理方法
     * @param args 被代理方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //方法前
        System.out.println("方法前");
        System.out.println("被代理方法名"+method.getName());
        System.out.println("被代理参数"+Arrays.toString(args));

        if (method.getName().equals("add")){
            int a= (int) args[0];
            int b= (int) args[1];

            args[0]=a*10;
            args[1]=b*10;
        }
        if(method.getName().equals("update")){
            String str=(String)args[0];
            args[0]="----"+str+"----";
        }

        //被增强方法执行
        Object invoke = method.invoke(obj, args);

        //方法后
        System.out.println("方法后执行");
        System.out.println(obj);
        System.out.println("被代理方法名"+method.getName());
        System.out.println("被代理参数"+Arrays.toString(args));

        //被代理方法返回值
        return invoke;
    }
}
