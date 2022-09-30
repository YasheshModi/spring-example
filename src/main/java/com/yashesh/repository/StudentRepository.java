package com.yashesh.repository;

import com.yashesh.entity.Country;
import com.yashesh.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {

   /* Student findByFirstNameOrLastName(String first_name,String last_name);
    Student findByEmail(String email);*/

    //Custom query
    //@Query(value = "select * from students s where s.first_Name like %:firstName% or s.last_Name like %:lastName%", nativeQuery = true)
    //List<Student> findByFirstNameOrLastName(String firstName,String lastName);

    List<Student> findByFirstName(String firstName);
    List<Student> findByLastName(String lastName);
    List<Student> findByEmail(String email);
    List<Student> findBySchoolId(Long schoolId);
    List<Student> findByCountryId(Long countryId);
}


