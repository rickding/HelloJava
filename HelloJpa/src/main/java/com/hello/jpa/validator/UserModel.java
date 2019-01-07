package com.hello.jpa.validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class UserModel {
    @NotBlank(message = "empty name")
    String name;

    @NotBlank(message = "empty account")
    String account;

    @NotBlank(message = "empty pwd")
    @Pattern(regexp = "^[0-9]{6}", message = "pwd not right")
    String pwd;

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
