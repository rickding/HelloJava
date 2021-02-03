package com.hello.shiro.service;

import com.hello.shiro.model.Permission;
import com.hello.shiro.model.Role;
import com.hello.shiro.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author dingxl
 */
@Service
public class UserService {
    static final Map<String, User> USER_MAP;

    static {
        Permission permissionsQuery = new Permission("1", Permission.QUERY);
        Permission permissionsAdd = new Permission("2", Permission.ADD);

        User admin = new User("1", "admin", "123456", new HashSet<Role>() {{
            add(new Role("1", Role.ADMIN, new HashSet<Permission>() {{
                add(permissionsQuery);
                add(permissionsAdd);
            }}));
        }});

        User user = new User("2", "user", "123456", new HashSet<Role>() {{
            add(new Role("2", Role.USER, new HashSet<Permission>() {{
                add(permissionsQuery);
            }}));
        }});

        USER_MAP = new HashMap<String, User>() {{
            put(admin.getUserName(), admin);
            put(user.getUserName(), user);
        }};
    }

    public User getUserByName(String userName) {
        return USER_MAP.get(userName);
    }
}
