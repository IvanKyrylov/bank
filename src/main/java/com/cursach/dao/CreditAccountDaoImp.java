package com.cursach.dao;

import com.cursach.entity.CreditAccount;
import com.cursach.entity.DepositAccount;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CreditAccountDaoImp implements AccountDao<CreditAccount> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<CreditAccount> allCredit() {
        return sessionFactory.getCurrentSession().createQuery("FROM CreditAccount ").list();
    }

    @Override
    public void addCredit(CreditAccount accountDepositOrCredit) {
        sessionFactory.getCurrentSession().persist(accountDepositOrCredit);
    }

    @Override
    public void deleteCredit(CreditAccount accountDepositOrCredit) {
        sessionFactory.getCurrentSession().delete(accountDepositOrCredit);
    }

    @Override
    public void editCredit(CreditAccount accountDepositOrCredit) {
        sessionFactory.getCurrentSession().update(accountDepositOrCredit);
    }

    @Override
    public CreditAccount getIdCredit(int idAccountCredit) {
        return sessionFactory.getCurrentSession().get(CreditAccount.class, idAccountCredit);
    }

    @Override
    public List<CreditAccount> findCreditByUserId(long idUser) {
        return sessionFactory.getCurrentSession().createQuery("FROM CreditAccount WHERE user.id = :paramName").setParameter("paramName", idUser).list();
    }
}
