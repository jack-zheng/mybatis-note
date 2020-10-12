package com.jzheng.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBUtils {

    private static final String URL = "jdbc:mysql://localhost:3306/mybatis";
    private static final String NAME = "root";
    private static final String PASSWORD = "12345678";

    private static Connection conn = null;

    static {
        //1.加载驱动程序
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //2.获得数据库的连接
        try {
            conn = DriverManager.getConnection(URL, NAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return conn;
    }

    public static void main(String[] args) throws Exception {
        //3.通过数据库的连接操作数据库，实现增删改查
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select id, name, pwd from user");//选择import java.sql.ResultSet;
        while (rs.next()) {//如果对象中有数据，就会循环打印出来
            System.out.println("Result: [" + rs.getInt("id") + ", " + rs.getString("name") + ", " + rs.getString("pwd") + "]");
        }
    }
}
