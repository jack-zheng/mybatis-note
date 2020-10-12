package com.jzheng.dao;

import com.jzheng.pojo.User;

import java.sql.SQLException;
import java.util.List;

public class UserDaoTest {
    public static void main(String[] args) throws SQLException {
        UserDao dao = new UserDao();
        List<User> users = dao.getUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }
}