package com.bookproject.dao.base;


import com.bookproject.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by zmzy on 2017/2/17.
 */
public class BaseDaoImpl<T> implements IBaseDao<T> {
    private SessionFactory sessionFactory;

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getSession(){
        return  sessionFactory.getCurrentSession();
    }


    public void add(T t) {
        Session session=getSession();
        session.save(t);
        session.close();
    }
}
