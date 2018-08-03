package com.hello.springboot;

import com.hello.mapper.FarmMapper;
import com.hello.model.Farm;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service(value="service")
public class ServiceImpl implements Service {
    @Autowired
    private FarmMapper farmMapper;

    @Override
    public List<Farm> selectFarm(String code) {
        return farmMapper.selectAll();
    }
}
