package com.yashesh.service;
import com.yashesh.entity.*;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();
    Student saveStudent(Student student);
    Student getStudentById(Long id);
    Student updateStudent(Student student);
    void deleteStudentById(Long id);

   // Student getStudentByFirstNameOrLastName(String first_name,String last_name);
   List<Student> getByFirstName(String firstName);
   List<Student> getByLastName(String lastName);
   List<Student> getByEmail(String email);
   List<Student> getByCountryId(Long countryId);
}