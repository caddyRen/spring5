package org.bougainvillea.spring5.ioc.service;

import org.bougainvillea.spring5.ioc.dao.UserDao;

/**
 * 注入外部bean
 * @author renqiankun
 */
public class UserService {

    UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add(){
        System.out.println("service add ....");
        userDao.update();
    }
}
