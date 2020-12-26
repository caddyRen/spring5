package org.bougainvillea.spring5.ioc.annotation.dao.impl;

import org.bougainvillea.spring5.ioc.annotation.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * 外部bean注入
 * @author renqiankun
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void update() {

        System.out.println("annotation UserDaoImpl is update");
    }
}
