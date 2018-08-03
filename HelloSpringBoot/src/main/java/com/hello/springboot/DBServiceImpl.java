package com.hello.springboot;

import com.hello.mapper.FarmMapper;
import com.hello.model.Farm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value="dbService")
public class DBServiceImpl implements DBService {
    @Autowired
    private FarmMapper farmMapper;

    @Override
    public List<Farm> selectFarm(String code) {
        return farmMapper.selectAll();
    }
}
