package com.cursach.dao;

import com.cursach.entity.Authorities;

import java.util.List;

public interface AuthoritiesDao {

    List<Authorities> allAuthorities();
    void add(Authorities users);
    void delete(Authorities users);
    void edit(Authorities users);
    Authorities getById(int id);
}
