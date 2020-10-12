package com.jzheng.dao;

import com.jzheng.pojo.User;
import com.jzheng.utils.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    List<User> getUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        Connection connection = DBUtils.getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select id, name, pwd from user");

        while (rs.next()) {
            User tmp = new User();
            tmp.setId(rs.getInt("id"));
            tmp.setName(rs.getString("name"));
            tmp.setPwd(rs.getString("pwd"));
            users.add(tmp);
        }
        return users;
    }
}
