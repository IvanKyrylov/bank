package com.cursach.dao;


import java.util.List;

public interface AccountDao<T> {
    List<T> allCredit();
    void addCredit(T accountDepositOrCredit);
    void deleteCredit(T accountDepositOrCredit);
    void editCredit(T accountDepositOrCredit);
    T getIdCredit(int idAccountDepositOrCredit);
    List<T> findCreditByUserId(long idUser);
}
