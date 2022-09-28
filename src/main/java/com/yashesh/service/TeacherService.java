package com.yashesh.service;

import com.yashesh.entity.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> getAllTeachers();
    Teacher saveTeacher(Teacher teacher);
    void deleteTeacherById(Long id);
    Teacher getTeacherById(Long id);
    Teacher updateTeacher(Teacher teacher);

}
