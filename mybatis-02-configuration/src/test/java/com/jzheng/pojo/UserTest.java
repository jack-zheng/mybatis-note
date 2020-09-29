package com.jzheng.pojo;

import org.junit.Test;

public class UserTest {
    @Test
    public void test_lombok_toString() {
        User user = new User();
        user.setId(1);
        user.setName("jack");
        user.setPassword("pwd");
        System.out.println(user);
    }
}