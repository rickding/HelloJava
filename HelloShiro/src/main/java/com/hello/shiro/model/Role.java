package com.hello.shiro.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

/**
 * @author dingxl
 */
@Data
@AllArgsConstructor
public class Role {
    public static final String ADMIN = "admin";
    public static final String USER = "user";

    private String id;
    private String roleName;
    private Set<Permission> permissions;
}
