package com.hello.hessian.model;

import java.io.Serializable;

/**
 * Created by user on 2017/6/4.
 */
public class HelloWorld implements Serializable {
    private static final long serialVersionUID = -271736299704714190L;

    private String name;

    public HelloWorld(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
