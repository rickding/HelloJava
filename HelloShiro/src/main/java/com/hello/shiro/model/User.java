package com.hello.shiro.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

/**
 * @author dingxl
 */
@Data
@AllArgsConstructor
public class User {
    private String id;
    private String userName;
    private String password;
    private Set<Role> roles;
}
