package com.jzheng.mapper;

import com.jzheng.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUserById(int id);
}
