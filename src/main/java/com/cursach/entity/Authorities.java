package com.cursach.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "authorities")
public class Authorities implements GrantedAuthority {

    @Id
    @Column(name = "authority")
    private String authority;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "id")
    private User user;

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Authorities{" +
                "authority='" + authority + '\'' +
                ", name='" + name + '\'' +
                ", user=" + user +
                '}';
    }
}
