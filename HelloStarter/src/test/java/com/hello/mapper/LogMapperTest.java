package com.hello.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;

@SpringBootTest
public class LogMapperTest {
    @Autowired
    LogMapper logMapper;

    @Test
    public void testSelect() {
        Collection ret = logMapper.selectList(null);
        ret.forEach(System.out::println);

        Assertions.assertFalse(ret.isEmpty());
    }
}
