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
- druid-1.1.20.jar
- spring-aop-5.2.6.RELEASE.jar
- spring-aspects-5.2.6.RELEASE.jar
- aopalliance-1.0.jar
- aspectjweaver-1.6.8.jar
- cglib-2.2.2.jar
- spring-jdbc-5.2.6.RELEASE.jar
- spring-orm-5.2.6.RELEASE.jar
- spring-tx-5.2.6.RELEASE.jar
- mysql-connector-java-8.0.21.jar
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
#### 基于annotation 引入spring-aop-5.2.6.RELEASE.jar
- 注解
    1. 注解是代码特殊标记。格式：@注解名(属性名=属性值,属性名=属性值)
    2. 可以作用在类，方法，属性上面  @Service、@Test、@Value、@Override
    3. 注解简化xml配置===>SpringBoot
- Spring提供的创建对象的注解，注意：四个注解功能一样，都能创建对象，只是为了web应用分层更清晰，约定大于规范
    1. @Component 普通
    2. @Service 业务逻辑层
    3. @Controller web层
    4. @Repository dao层
- 使用
    1. 引入context名称空间开启组件扫描，设置扫描范围```<context:component-scan base-package="org.bougainvillea.spring5.ioc.annotation"/>``
    2. 使用注解
##### 注解注入属性
- POJO属性注入
    -  @Autowired 跟据属性类型自动装配
    -  @Qualifier 根据属性名注入
    -  @Resource  可以根据属性名称注入，可以根据属性类型注入
        - 不是Spring包中注解 import javax.annotation.Resource;
        - 建议使用Autowired，Qualifier
- 注入普通类型
    - @Value
#### 基于XML
1. 创建对象
    - 默认找无参构造器创建对象
    ```xml
    <bean id="user" class="org.bougainvillea.spring5.ioc.xml.User"></bean>
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
##### POJOBean（普通Bean） & FactoryBean（工厂bean）
- 普通bean：在配置文件中定义bean类型=返回的类型
- 工厂bean：在配置文件中定义bean类型≠返回的类型
    - 创建类作为工厂Bean 实现FactoryBean
    - 实现接口方法，在实现的方法中定义返回的bean类型
##### bean作用域 scope
- 单例（Spring默认值）singleton
```xml
<bean id="book" class="org.bougainvillea.spring5.ioc.xml.Book" scope="singleton"/>
```
- 多例 prototype
```xml
<bean id="book" class="org.bougainvillea.spring5.ioc.xml.Book" scope="prototype"/>
```
- 区别
    - singleton单例,prototype多例
    - singleton加载配置文件时就会创建一个单例对象
    - prototype在获取bean ```context.getBean("book", Book.class)``` 时才创建对象
- 不常用值
    - request
    - session
##### bean生命周期
1. 通过构造器创建bean实例（有参构造器，无参构造器，工厂bean）
2. DI 注入属性（set方法，ref引用）
3.1 把bean实例传递给bean后置处理器的方法
3.2 调用bean初始化方法（需要配置）
3.3 把bean实例传递给bean后置处理器的方法
4. bean可以使用（获取对象）
5. 当容器关闭时，调用bean的销毁方法（需要进行配置销毁的方法）
- 后置处理器
    1. 创建类 实现BeanPostProcessor接口
    2. 默认会将当前配置文件内的所有bean都配置上后置处理器
##### 自动装配
1. 根据指定装配规则（属性名称或者属性类型），Spring自动将匹配的属性值注入，一种简化写法

## AOP
1. 面向切面编程，aop是oop的延续，利用aop可以对业务逻辑的各个部分进行隔离，从而使业务逻辑各部分之间耦合度降低，提高程序的可重复性，提高开发效率
2. 场景：日志，性能统计，安全控制，事务处理，异常处理等从业务代码中分出来，可以在不修改源代码的情况下，增加主业务功能
3. 引入spring-aspects-5.2.6.RELEASE.jar、aopalliance-1.0.jar、aspectjweaver-1.6.8.jar、cglib-2.2.2.jar
### 底层原理
#### 动态代理
##### 有接口jdk动态代理
- java.lang.reflect.Proxy
    - 方法：newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h);返回指定接口的代理类的实例，该接口将方法调用分派给指定的调用处理程序
    - 参数
        - ClassLoader loader: 类加载器
        - Class<?>[] interfaces: 需要增强的方法所在的类所实现的接口，支持多个接口
        - InvocationHandler h: 实现这个接口InvocationHandler，创建代理对象，写增强方法

##### 无接口cgLib代理
### 术语
- 连接点：类中可以被增强的方法
- 切入点：类中具体实现了增强功能的方法
- 通知 增强
    - @Before 前置通知
    - @AfterReturning  后置通知，有异常不会执行 日志
    - @After 最终通知 类似finally 无论是否异常都会执行增强 常用于日志
    - @Around 环绕通知 控制事务 权限控制
    - @AfterThrowing 异常通知 异常处理 控制事务
- 切面：动作 把增强应用到切入点的过程
### AspectJ框架
- AspectJ独立的AOP框架，不是Spring的组成部分
- 把AspectJ框架和Spring框架一起使用进行AOP操作
### 切入点表达式：execution
- execution([权限修饰符][返回类型][类全路径][方法名称]([参数列表]))
- execution(* org.bougainvillea.spring5.aop.Bean.add(..))对Bean下的add方法增强
- execution(* org.bougainvillea.spring5.aop.Bean.*(..))对Bean下的所有方法增强
## JdbcTemplate
1. Spring对JDBC进行封装，使用JdbcTemplate对数据库操作
2. 引入jar mysql-connector-java-8.0.21.jar、spring-jdbc-5.2.6.RELEASE.jar、spring-tx-5.2.6.RELEASE.jar、spring-orm-5.2.6.RELEASE.jar
## Transaction

## new