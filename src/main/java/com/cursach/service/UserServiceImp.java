package com.cursach.service;


import com.cursach.dao.AuthoritiesDao;
import com.cursach.dao.UserDao;
import com.cursach.entity.Authorities;
import com.cursach.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


@Service("userDetailService")
public class UserServiceImp implements UserDetailsService, UserService{

    @Autowired
    private UserDao userDao;

    @Autowired
    private AuthoritiesDao authoritiesDao;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findUserByUsername(username);
        UserBuilder builder = null;
        if (user != null) {

            builder = org.springframework.security.core.userdetails.User.withUsername(username);
            builder.disabled(!user.isEnabled());
            builder.password(user.getPassword());
            String[] authorities = user.getAuthorities()
                    .stream().map(Authorities::getAuthority).toArray(String[]::new);

            builder.authorities(authorities);
        } else {
            throw new UsernameNotFoundException("User not found.");
        }
        return builder.build();
    }

    @Transactional
    @Override
    public List<User> allUser() {
        return userDao.allUser();
    }

    @Transactional
    @Override
    public boolean add(User user) {
        if (userDao.findUserByUsername(user.getUsername()) == null || !userDao.findUserByUsername(user.getUsername()).getUsername().equals(user.getUsername())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setCreateTime(new Timestamp(new Date().getTime()));
            user.setEnabled(true);
            Authorities authorities = new Authorities();
            authorities.setAuthority("ROLE_USER");
            authorities.setName(user.getUsername());
            authorities.setUser(user);
            userDao.add(user);
            authoritiesDao.add(authorities);
            return true;
        }else return false;

        //хуйня переделать
    }

    @Transactional
    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Transactional
    @Override
    public void edit(User user) {
        userDao.edit(user);
    }

    @Transactional
    @Override
    public User getById(int id) {
        return userDao.getById(id);
    }

}
