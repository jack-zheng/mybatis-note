package com.jzheng.mapper;

import com.jzheng.pojo.Teacher;
import com.jzheng.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TeacherMapperTest {
    @Test
    public void test_get_all() {
        SqlSession session = MybatisUtils.getSqlSession();
        List<Teacher> teachers = session.getMapper(TeacherMapper.class).getTeachers();
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
        session.close();
    }

    @Test
    public void test_get_allV2() {
        SqlSession session = MybatisUtils.getSqlSession();
        List<Teacher> teachers = session.getMapper(TeacherMapper.class).getTeachersV2();
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
        session.close();
    }
}