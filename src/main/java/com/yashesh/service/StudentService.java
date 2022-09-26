package com.yashesh.service;
import com.yashesh.entity.*;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();
    Student saveStudent(Student student);
}