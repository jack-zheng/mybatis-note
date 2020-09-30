package com.jzheng.mapper;

import com.jzheng.pojo.Student;

import java.util.List;

public interface StudentMapper {
    List<Student> getStudents();

    List<Student> getStudentsV2();
}
