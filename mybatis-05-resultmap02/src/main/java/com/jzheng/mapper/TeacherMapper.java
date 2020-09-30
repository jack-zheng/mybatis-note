package com.jzheng.mapper;

import com.jzheng.pojo.Teacher;

import java.util.List;

public interface TeacherMapper {
    List<Teacher> getTeachers();

    List<Teacher> getTeachersV2();
}
