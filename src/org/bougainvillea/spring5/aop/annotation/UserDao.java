package org.bougainvillea.spring5.aop.annotation;

import org.springframework.stereotype.Component;

/**
 * 外AOP Annotation
 * @author renqiankun
 */
@Component
public class UserDao {

    public void add() {
        System.out.println("AOP Annotation");
    }

    public String update(String id) {
        int a=10/0;
        System.out.println("AOP Annotation");
        return id;
    }
}
