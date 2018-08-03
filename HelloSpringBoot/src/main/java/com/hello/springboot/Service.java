package com.hello.springboot;

import com.hello.model.Farm;

import java.util.List;

public interface Service {
    List<Farm> selectFarm(String code);
}
