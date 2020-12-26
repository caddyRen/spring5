package org.bougainvillea.spring5.ioc.lifecycle;

/**
 * bean 生命周期
 * @author renqiankun
 */
public class Order {

    private String name;

    /**
     * 无参构造器
     */
    public Order() {
        System.out.println("第一步：执行无参构造器，创建bean");
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("第二步：注入属性");
    }

    /**
     * 初始化方法
     * 需要在xml配置才会执行
     */
    public void initMethod(){
        System.out.println("第三步：调用初始化方法");
    }

    /**
     * ioc容器关闭，销毁bean
     */
    public void destroyMethod(){
        System.out.println("最后一步：ioc容器关闭，调用bean销毁方法");
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                '}';
    }
}
