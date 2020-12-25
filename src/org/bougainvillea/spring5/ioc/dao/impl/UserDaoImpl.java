package org.bougainvillea.spring5.ioc.dao.impl;

import org.bougainvillea.spring5.ioc.dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public void update() {

        System.out.println("UserDaoImpl is update");
    }
}
