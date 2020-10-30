package mapper;

import com.jzheng.mapper.UserMapper;
import com.jzheng.utils.MybatisUtils;
import org.junit.Test;

public class UserMapperTest {

    @Test
    public void getUsers() {
        System.out.println(MybatisUtils.getSession().getMapper(UserMapper.class).getUserById(1));
    }

}