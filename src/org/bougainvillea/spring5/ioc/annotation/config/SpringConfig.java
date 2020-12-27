package org.bougainvillea.spring5.ioc.annotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 完全基于注解实现ioc
 *
 * @author renqiankun
 */
@Configuration
@ComponentScan(basePackages = {"org.bougainvillea.spring5.ioc.annotation"})
public class SpringConfig {

}
