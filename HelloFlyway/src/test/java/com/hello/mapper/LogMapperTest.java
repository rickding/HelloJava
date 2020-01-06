package com.hello.mapper;

import com.hello.model.Log;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.Date;

@SpringBootTest
public class LogMapperTest {
    @Autowired
    LogMapper logMapper;

    @Test
    public void testInsert() {
        int ret = logMapper.insert(new Date().toString());
        System.out.println(ret);

        Assertions.assertTrue(ret > 0);
    }

    @Test
    public void testSelect() {
        Collection<Log> ret = logMapper.select(111);
        System.out.println(ret.size());

        Assertions.assertFalse(ret.isEmpty());
    }
}
