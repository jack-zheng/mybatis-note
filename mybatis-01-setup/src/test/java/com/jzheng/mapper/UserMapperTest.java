package com.jzheng.mapper;

import com.jzheng.pojo.User;
import com.jzheng.utils.MybatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserMapperTest {
    @Test
    public void test_official_sample() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.getUsers();
        for (User user : users) {
            System.out.println(user);
        }
        session.close();
    }

    @Test
    public void test_util() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        List<User> users = sqlSession.getMapper(UserMapper.class).getUsers();
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }
}