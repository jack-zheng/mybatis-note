package com.jzheng.mapper;

import com.jzheng.pojo.User;
import com.jzheng.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UserMapperTest {
    @Test
    public void test_get() {
        SqlSession session = MybatisUtils.getSqlSession();
        User user = session.getMapper(UserMapper.class).getUserById(1);
        System.out.println(user);
        session.close();
    }
}