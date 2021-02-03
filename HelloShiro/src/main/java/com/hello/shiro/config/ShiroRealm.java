package com.hello.shiro.config;

import com.hello.shiro.model.Permission;
import com.hello.shiro.model.Role;
import com.hello.shiro.model.User;
import com.hello.shiro.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

/**
 * @author dingxl
 */
public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    UserService userService;

    /**
     * 权限配置类
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 查询用户
        String name = principalCollection.getPrimaryPrincipal().toString();
        User user = userService.getUserByName(name);
        if (user == null) {
            return null;
        }

        // 添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        for (Role role : user.getRoles()) {
            simpleAuthorizationInfo.addRole(role.getRoleName());

            for (Permission permissions : role.getPermissions()) {
                simpleAuthorizationInfo.addStringPermission(permissions.getPermissionName());
            }
        }
        return simpleAuthorizationInfo;
    }

    /**
     * 认证配置类
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        if (StringUtils.isEmpty(authenticationToken.getPrincipal())) {
            return null;
        }

        // 获取用户信息
        String name = authenticationToken.getPrincipal().toString();
        User user = userService.getUserByName(name);

        // 验证authenticationToken和simpleAuthenticationInfo
        return user == null ? null : new SimpleAuthenticationInfo(name, user.getPassword(), getName());
    }
}
