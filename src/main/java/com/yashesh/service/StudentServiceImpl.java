package com.yashesh.service;

import com.yashesh.entity.Country;
import com.yashesh.entity.Student;
import com.yashesh.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        super();
        this.studentRepository = studentRepository;
    }
    @Override
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }
    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }
    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> getByFirstName(String firstName){
        List<Student> byFirstName = studentRepository.findByFirstName(firstName);
        return byFirstName;
    }

    @Override
    public List<Student> getByLastName(String lastName){
        List<Student> byLastName = studentRepository.findByLastName(lastName);
        return  byLastName;
    }

    @Override
    public List<Student> getByEmail(String email) {
        List<Student> byEmail = studentRepository.findByEmail(email);
        return byEmail;
    }

    @Override
    public List<Student> getByCountryId(Long countryId) {
        List<Student> byCountry = studentRepository.findByCountryId(countryId);
        return byCountry;
    }

    @Override
    public List<Student> getBySchoolId(Long schoolId) {
        List<Student> bySchool = studentRepository.findBySchoolId(schoolId);
        return bySchool;
    }
     /*  @Override
    public Student getStudentByFirstNameOrLastName(String first_name,String last_name) {
        return studentRepository.findByFirstNameOrLastName(first_name,last_name);
    }*/
}