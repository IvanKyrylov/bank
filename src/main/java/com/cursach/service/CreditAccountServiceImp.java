package com.cursach.service;

import com.cursach.dao.AccountDao;
import com.cursach.dao.UserDao;
import com.cursach.entity.CreditAccount;
import com.cursach.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class CreditAccountServiceImp implements AccountService<CreditAccount> {

    @Autowired
    private AccountDao<CreditAccount> accountDao;

    @Transactional
    @Override
    public List<CreditAccount> allCredit() {
        return accountDao.allCredit();
    }

    @Transactional
    @Override
    public void addCredit(User user) {
        CreditAccount creditAccount = new CreditAccount();
        creditAccount.setCreditLimit(100000L);
        creditAccount.setCredit(2500L);
        creditAccount.setInterestRate(10L);
        creditAccount.setPercent(250L);
        creditAccount.setCreateTime(new Timestamp(new Date().getTime()));
        creditAccount.setReturn_time(new Timestamp(new Date().getTime()* 1000000000));
        creditAccount.setUser(user);
        accountDao.addCredit(creditAccount);
    }

    @Transactional
    @Override
    public void deleteCredit(CreditAccount accountDepositOrCredit) {
        accountDao.deleteCredit(accountDepositOrCredit);
    }

    @Transactional
    @Override
    public void editCredit(CreditAccount accountDepositOrCredit) {
        accountDao.editCredit(accountDepositOrCredit);
    }

    @Transactional
    @Override
    public CreditAccount getIdCredit(int idAccountDepositOrCredit) {
        return accountDao.getIdCredit(idAccountDepositOrCredit);
    }

    @Transactional
    @Override
    public List<CreditAccount> findCreditByUserId(long id) {
        return accountDao.findCreditByUserId(id);
    }

}
