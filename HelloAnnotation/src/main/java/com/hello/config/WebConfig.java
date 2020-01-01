package com.hello.config;

import com.hello.interceptor.AccessInterceptor;
import com.hello.interceptor.ClientIPInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Autowired
    AccessInterceptor accessInterceptor;

    @Autowired
    ClientIPInterceptor clientIPInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(accessInterceptor).addPathPatterns("/**");
        registry.addInterceptor(clientIPInterceptor).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
