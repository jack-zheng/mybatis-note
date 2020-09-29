package com.jzheng.mapper;

import com.jzheng.pojo.User;
import com.jzheng.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UserMapperTest {
    @Test
    public void get_user(){
        SqlSession session = MybatisUtils.getSqlSession();

        User user = session.getMapper(UserMapper.class).getUserById(1);
        System.out.println(user);

        session.close();
    }

    @Test
    public void test_getUserInXml() {
        SqlSession session = MybatisUtils.getSqlSession();

        User user = session.getMapper(UserMapper.class).getUserInXml(1);
        System.out.println(user);

        session.close();
    }

    @Test
    public void test_insert() {
        SqlSession session = MybatisUtils.getSqlSession();

        User user = new User();
        user.setId(101);
        user.setName("J100");
        user.setPassword("P100");
        session.getMapper(UserMapper.class).insertUser(user);

        session.close();
    }

}