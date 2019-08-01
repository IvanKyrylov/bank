package com.cursach.service;

import com.cursach.entity.User;

import java.util.List;

public interface UserService {
    List<User> allUser();
    boolean add(User user);
    void delete(User user);
    void edit(User user);
    User getById(int id);
}
