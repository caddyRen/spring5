package org.bougainvillea.spring5.aop.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"org.bougainvillea.spring5.aop.annotation"})
@EnableAspectJAutoProxy(proxyTargetClass = true)//相当于xml里的<aop:aspectj-autoproxy></aop:aspectj-autoproxy>
public class AOPConfig {
}
