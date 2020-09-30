package com.jzheng.mapper;

import com.jzheng.pojo.Student;
import com.jzheng.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class StudentMapperTest {
    @Test
    public void test_get_all() {
        SqlSession session = MybatisUtils.getSqlSession();
        List<Student> studentList = session.getMapper(StudentMapper.class).getStudents();
        for (Student student : studentList) {
            System.out.println(student);
        }
        session.close();
    }

    @Test
    public void test_get_allV2() {
        SqlSession session = MybatisUtils.getSqlSession();
        List<Student> studentList = session.getMapper(StudentMapper.class).getStudentsV2();
        for (Student student : studentList) {
            System.out.println(student);
        }
        session.close();
    }
}