package com.cursach.service;

import com.cursach.entity.User;

import java.util.List;

public interface AccountService<T> {
    List<T> allCredit();

    void addCredit(User user);

    void deleteCredit(T accountDepositOrCredit);

    void editCredit(T accountDepositOrCredit);

    T getIdCredit(int idAccountDepositOrCredit);

    List<T> findCreditByUserId(long id);}
