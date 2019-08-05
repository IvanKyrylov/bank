package com.cursach.dao;

import com.cursach.entity.DepositAccount;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepositAccountDaoImp implements AccountDao<DepositAccount> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<DepositAccount> allCredit() {
        return sessionFactory.getCurrentSession().createQuery("FROM CreditAccount ").list();
    }

    @Override
    public void addCredit(DepositAccount accountDepositOrCredit) {
        sessionFactory.getCurrentSession().persist(accountDepositOrCredit);

    }

    @Override
    public void deleteCredit(DepositAccount accountDepositOrCredit) {
        sessionFactory.getCurrentSession().delete(accountDepositOrCredit);
    }

    @Override
    public void editCredit(DepositAccount accountDepositOrCredit) {
        sessionFactory.getCurrentSession().update(accountDepositOrCredit);
    }

    @Override
    public DepositAccount getIdCredit(int idAccountDepositOrCredit) {
        return sessionFactory.getCurrentSession().get(DepositAccount.class, idAccountDepositOrCredit);
    }

    @Override
    public List<DepositAccount> findCreditByUserId(long idUser) {
        return sessionFactory.getCurrentSession().createQuery("FROM DepositAccount Account WHERE user.id = :paramName").setParameter("paramName", idUser).list();
    }
}
