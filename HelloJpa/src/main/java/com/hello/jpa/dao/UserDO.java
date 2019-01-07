package com.hello.jpa.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "auth_user")
public class UserDO {
    @Id
    Long id;

    @Column(length = 32)
    String name;

    @Column(length = 32)
    String account;

    @Column(length = 64)
    String pwd;

    @Override
    public String toString() {
        return String.format("userDO: %d, %s, %s, %s", id, name, account, pwd);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
