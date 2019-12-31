package com.hello.annotation;

import com.hello.annotation.interceptor.AccessInterceptor;
import com.hello.annotation.interceptor.ClientIPInterceptor;
import com.hello.annotation.interceptor.ClientIPResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Autowired
    AccessInterceptor accessInterceptor;

    @Autowired
    ClientIPInterceptor clientIPInterceptor;

    @Autowired
    ClientIPResolver clientIPResolver;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(accessInterceptor).addPathPatterns("/**");
        registry.addInterceptor(clientIPInterceptor).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(clientIPResolver);
        super.addArgumentResolvers(argumentResolvers);
    }
}
