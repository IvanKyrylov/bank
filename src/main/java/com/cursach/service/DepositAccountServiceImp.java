package com.cursach.service;

import com.cursach.dao.AccountDao;
import com.cursach.dao.UserDao;
import com.cursach.entity.DepositAccount;
import com.cursach.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepositAccountServiceImp implements AccountService<DepositAccount> {

    @Autowired
    private AccountDao<DepositAccount> accountDao;

    @Transactional
    @Override
    public List<DepositAccount> allCredit() {
        return accountDao.allCredit();
    }

    @Transactional
    @Override
    public void addCredit(User user) {
        DepositAccount depositAccount = new DepositAccount();
        depositAccount.setDeposit_amount(0L);
        depositAccount.setRate(10L);
        depositAccount.setUser(user);
        accountDao.addCredit(depositAccount);
    }

    @Transactional
    @Override
    public void deleteCredit(DepositAccount accountDepositOrCredit) {
        accountDao.deleteCredit(accountDepositOrCredit);
    }

    @Transactional
    @Override
    public void editCredit(DepositAccount accountDepositOrCredit) {
        accountDao.editCredit(accountDepositOrCredit);
    }

    @Transactional
    @Override
    public DepositAccount getIdCredit(int idAccountDepositOrCredit) {
        return accountDao.getIdCredit(idAccountDepositOrCredit);
    }

    @Transactional
    @Override
    public List<DepositAccount> findCreditByUserId(long id) {
        return accountDao.findCreditByUserId(id);
    }

}
