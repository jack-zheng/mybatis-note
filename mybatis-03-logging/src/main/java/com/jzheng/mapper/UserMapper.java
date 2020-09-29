package com.jzheng.mapper;


import com.jzheng.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    User getUserById(int id);

    @Select("select * from mybatis.user")
    List<User> getUsers();
}
