package com.hello.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hello.entity.Log;
import com.hello.util.LogUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class LogMapperTest {
    @Autowired
    LogMapper logMapper;

    @Test
    public void testInsert() {
        int ret = logMapper.insert(new Log() {{
            setSummary(new Date().toString());
        }});
        LogUtil.info(ret);

        Assertions.assertTrue(ret > 0);
    }

    @Test
    public void testSelect() {
        List<Log> ret = logMapper.selectList(new QueryWrapper<Log>()
                .orderByDesc("id")
                .last(true, "limit 2")
        );
        ret.forEach(LogUtil::info);

        Assertions.assertFalse(ret.isEmpty());
    }
}
