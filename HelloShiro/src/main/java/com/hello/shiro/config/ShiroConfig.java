package com.hello.shiro.config;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class ShiroConfig {
    @Bean
    @ConditionalOnMissingBean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        return new DefaultAdvisorAutoProxyCreator() {{
            setProxyTargetClass(true);
        }};
    }

    /**
     * 将验证方式加入容器
     */
    @Bean
    public ShiroRealm shiroRealm() {
        return new ShiroRealm();
    }

    /**
     * 配置Realm管理认证
     */
    @Bean
    public SecurityManager securityManager() {
        return new DefaultWebSecurityManager() {{
            setRealm(shiroRealm());
        }};
    }

    /**
     * 设置对应的过滤条件和跳转条件
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean filterFactory = new ShiroFilterFactoryBean() {{
            // 登录
            setLoginUrl("/login");
            // 首页
            setSuccessUrl("/index");
            // 错误页面，认证不通过跳转
            setUnauthorizedUrl("/error");
        }};

        filterFactory.setFilterChainDefinitionMap(new HashMap<String, String>() {{
            // 登出
            put("/logout", "logout");

            // 对所有用户认证
            put("/**", "authc");
        }});

        filterFactory.setSecurityManager(securityManager);
        return filterFactory;
    }

    /**
     * 注入权限管理
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }
}
