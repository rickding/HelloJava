package com.hello.mapper;

import com.hello.model.Log;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Collection;

@Mapper
public interface LogMapper {
    @Select("select * from log limit #{count};")
    Collection<Log> select(int count);

    @Insert("insert into log(summary) values(#{summary});")
    int insert(String summary);
}
