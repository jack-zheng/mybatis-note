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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Test
    public void test_add() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        User user = new User(4, "t0928", "pwd");

        int ret = sqlSession.getMapper(UserMapper.class).addUser(user);
        System.out.println(ret);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test_delete() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        int ret = sqlSession.getMapper(UserMapper.class).deleteUser(5);
        System.out.println(ret);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test_update() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        User user = new User(2, "change", "pwdchange");
        int ret = sqlSession.getMapper(UserMapper.class).updateUser(user);
        System.out.println(ret);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test_getUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        User ret = sqlSession.getMapper(UserMapper.class).getUserById(1);
        System.out.println(ret);
        sqlSession.close();
    }

    @Test
    public void test_getUserByMap() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        Map<String, Object> map = new HashMap<>();
        map.put("id", 1);
        User ret = sqlSession.getMapper(UserMapper.class).getUserByMap(map);
        System.out.println(ret);
        sqlSession.close();
    }

    @Test
    public void test_limit() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        Map<String, Object> map = new HashMap<>();
        map.put("startIndex", 2);
        map.put("pageSize", 2);
        List<User> ret = sqlSession.getMapper(UserMapper.class).getUsersWithLimit(map);
        for (User u : ret) {
            System.out.println(u);
        }
        sqlSession.close();
    }
}