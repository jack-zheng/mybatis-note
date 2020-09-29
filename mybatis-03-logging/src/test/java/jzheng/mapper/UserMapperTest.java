package jzheng.mapper;

import com.jzheng.mapper.UserMapper;
import com.jzheng.pojo.User;
import com.jzheng.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {
    @Test
    public void test_query() {
        SqlSession session = MybatisUtils.getSqlSession();

        System.out.println(session.getMapper(UserMapper.class).getUserById(1));

        session.close();
    }

    @Test
    public void test_get_all() {
        SqlSession session = MybatisUtils.getSqlSession();

        List<User> users = session.getMapper(UserMapper.class).getUsers();
        System.out.println("Find user count: " + users.size());

        session.close();
    }
}