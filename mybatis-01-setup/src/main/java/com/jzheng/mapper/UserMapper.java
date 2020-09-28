package com.jzheng.mapper;

import com.jzheng.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    // CURD user
    int addUser(User user);
    int deleteUser(int id);
    int updateUser(User user);
    User getUserById(int id);

    // First sample
    List<User> getUsers();

    // Map as parameter
    User getUserByMap(Map map);
}
