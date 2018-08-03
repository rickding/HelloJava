package com.hello.springboot;

import com.hello.model.Farm;

import java.util.List;

public interface DBService {
    List<Farm> selectFarm(String code);
}
