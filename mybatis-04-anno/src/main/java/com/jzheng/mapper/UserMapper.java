package com.jzheng.mapper;

import com.jzheng.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("select * from mybatis.user where id=#{id}")
    User getUserById(@Param("id") int id);

    User getUserInXml(int id);

    // 当参数是对象时，直接传入即可，但要保证属性名一致
    @Insert("insert into mybatis.user (id, name, pwd) values (#{id}, #{name}, #{password})")
    int insertUser(User user);
}
