package org.bougainvillea.spring5.jdbc.service.transaction;

import org.bougainvillea.spring5.jdbc.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 事务
 */
@Service
public class ServiceImpl {

    @Autowired
    UserDao userDao;

    public void age1(int reduce,int add, int num){
        userDao.reduceAge(reduce,num);
        int a=10/0;
        userDao.addAge(add,num);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void age(int reduce,int add, int num){
        userDao.reduceAge(reduce,num);
        userDao.addAge(add,num);
        age1(reduce,add,num);
    }


}
