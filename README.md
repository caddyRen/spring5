[toc]
# spring5
spring framework 5.2.6 study
# 需要的jar包
- commons-logging-1.1.1.jar
- hamcrest-core-1.3.jar
- junit-4.13.jar
- spring-beans-5.2.6.RELEASE.jar
- spring-context-5.2.6.RELEASE.jar
- spring-core-5.2.6.RELEASE.jar
- spring-expression-5.2.6.RELEASE.jar

## IOC
1. 控制反转-把对象创建和对象之间的调用过程，交给spring管理
2. 目的是降低耦合度
### 底层原理
1. xml解析、工厂模式、反射
### BeanFactory接口
1. IOC思想基于IOC容器完成，IOC容器底层就是对象工厂
2. Spring提供IOC容器实现两种方式
    1. BeanFactory: IOC容器基本实现，spring内部使用接口，不提供给开发人员使用
        - 加载配置文件时不会创建对象，获取bean时才创建对象
    2. ApplicationContext: BeanFactory的子接口，提供更多更强大的功能，一般使用此接口
        - 加载配置文件时就创建对象
        - 主要实现类
            - FileSystemXmlApplicationContext 绝对路径
            - ClassPathXmlApplicationContext  项目路径
    3. 实际使用时，将创建对象这种耗时耗资源的工作，在项目启动时处理更合理
### 管理Bean
1. 创建对象
2. 注入属性
#### 基于XML
1. 创建对象
    - 默认找无参构造器创建对象
    ```xml
    <bean id="user" class="org.bougainvillea.spring5.ioc.User"></bean>
   ```
   - id属性：唯一标识 不能重复 不能有特殊符合
   - class属性：包类全路径
   - name属性：早期为status1框架提供的属性，能传特殊字符，使用较少
2. 注入属性
    - DI：依赖注入~注入属性，是IOC的一种具体实现
    - setter注入
        - 字面量
            - 注入特殊字符 <![CDATA[<<西游记>>]]>
            - 注入空值 <null/>
        - 注入bean ref注入，内部bean注入，需要有get方法的内部bean注入写法
        
    - 有参构造器注入
    

#### 基于annotation

## AOP
## JdbcTemplate
## Transaction
## new