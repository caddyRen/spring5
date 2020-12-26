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
#### 自动装配
1. 根据指定装配规则（属性名称或者属性类型），Spring自动将匹配的属性值注入，一种简化写法

#### bean生命周期
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
#### bean作用域 scope
- 单例（Spring默认值）singleton
```xml
<bean id="book" class="org.bougainvillea.spring5.ioc.Book" scope="singleton"/>
```
- 多例 prototype
```xml
<bean id="book" class="org.bougainvillea.spring5.ioc.Book" scope="prototype"/>
```
- 区别
    - singleton单例,prototype多例
    - singleton加载配置文件时就会创建一个单例对象
    - prototype在获取bean ```context.getBean("book", Book.class)``` 时才创建对象
- 不常用值
    - request
    - session
#### POJOBean（普通Bean） & FactoryBean（工厂bean）
- 普通bean：在配置文件中定义bean类型=返回的类型
- 工厂bean：在配置文件中定义bean类型≠返回的类型
    - 创建类作为工厂Bean 实现FactoryBean
    - 实现接口方法，在实现的方法中定义返回的bean类型
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