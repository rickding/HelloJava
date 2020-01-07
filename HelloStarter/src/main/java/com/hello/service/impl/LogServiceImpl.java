package com.hello.service.impl;

import com.hello.entity.Log;
import com.hello.mapper.LogMapper;
import com.hello.service.ILogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Ding
 * @since 2020-01-07
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements ILogService {

}
