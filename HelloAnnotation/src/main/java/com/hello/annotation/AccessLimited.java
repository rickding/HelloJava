package com.hello.annotation;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Order(Ordered.HIGHEST_PRECEDENCE)
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AccessLimited {
    int count() default 5;
    int seconds() default 1;
    boolean ip() default false;
    boolean session() default true;
}
