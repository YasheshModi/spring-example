package com.yashesh.service;
import com.yashesh.entity.*;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();
    Student saveStudent(Student student);
    Student getStudentById(Long id);
    Student updateStudent(Student student);
    void deleteStudentById(Long id);

    Student getStudentByFirstNameorLastName(Student student);
}