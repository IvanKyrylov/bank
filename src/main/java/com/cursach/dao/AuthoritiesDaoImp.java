package com.cursach.dao;

import com.cursach.entity.Authorities;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthoritiesDaoImp implements AuthoritiesDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Authorities> allAuthorities() {
        return sessionFactory.getCurrentSession().createQuery("FROM User ").list();
    }

    @Override
    public void add(Authorities authorities) {
        sessionFactory.getCurrentSession().persist(authorities);
    }

    @Override
    public void delete(Authorities authorities) {
        sessionFactory.getCurrentSession().delete(authorities);
    }

    @Override
    public void edit(Authorities authorities) {
        sessionFactory.getCurrentSession().update(authorities);
    }

    @Override
    public Authorities getById(int id) {
        return sessionFactory.getCurrentSession().get(Authorities.class, id);
    }

}
