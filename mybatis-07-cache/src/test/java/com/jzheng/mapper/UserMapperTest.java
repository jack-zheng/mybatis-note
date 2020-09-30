package com.jzheng.mapper;

import com.jzheng.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserMapperTest {

    @Test
    public void getUsers() {
        SqlSession session = MybatisUtils.getSqlSession();
        System.out.println("-----> query user1 the first time <-----");
        session.getMapper(UserMapper.class).getUserById(1);
        session.clearCache();
        System.out.println("-----> query user1 the second time <-----");
        session.getMapper(UserMapper.class).getUserById(1);
        session.close();
    }

    @Test
    public void getUsers_diff_session() {
        SqlSession session1 = MybatisUtils.getSqlSession();
        System.out.println("-----> query user1 the first time <-----");
        session1.getMapper(UserMapper.class).getUserById(1);
        session1.close();

        SqlSession session2 = MybatisUtils.getSqlSession();
        System.out.println("-----> query user1 the second time <-----");
        session2.getMapper(UserMapper.class).getUserById(1);
        session2.close();
    }
}