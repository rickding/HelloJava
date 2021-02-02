package com.hello.shiro.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author dingxl
 */
@Data
@AllArgsConstructor
public class Permission {
    public static final String QUERY = "query";
    public static final String ADD = "add";

    private String id;
    private String permissionName;
}
