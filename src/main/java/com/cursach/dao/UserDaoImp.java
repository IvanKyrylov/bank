package com.cursach.dao;

import com.cursach.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    private final SessionFactory sessionFactory;

    public UserDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<User> allUser() {
        return sessionFactory.getCurrentSession().createQuery("FROM User ").list();
    }

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().persist(user);
    }

    @Override
    public void delete(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

    @Override
    public void edit(User users) {
        sessionFactory.getCurrentSession().update(users);
    }

    @Override
    public User getById(int id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public User findUserByUsername(String username) {
//        return (User) sessionFactory.getCurrentSession().createQuery("FROM User WHERE username = :paramName").setParameter("paramName", username).uniqueResult();
        for ( User user : allUser()) {
            if (user.getUsername().equals(username) ) {
                return user;
            }
        }
        return null;
    }
}
