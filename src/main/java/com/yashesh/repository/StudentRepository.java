package com.yashesh.repository;

import com.yashesh.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {

    Student findByFirstNameOrLastName(String name);
    Student findByEmail(String email);
}


