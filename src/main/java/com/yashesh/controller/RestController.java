package com.yashesh.controller;

import com.yashesh.dto.CountryDto;
import com.yashesh.dto.SchoolDto;
import com.yashesh.entity.Country;
import com.yashesh.entity.School;
import com.yashesh.entity.Student;
import com.yashesh.service.CountryService;
import com.yashesh.service.SchoolService;
import com.yashesh.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    StudentService studentService;
    @Autowired
    SchoolService schoolService;

    @Autowired
    CountryService countryService;

    @GetMapping("/api/students")
    public List<Student> liststudents() {
        List<Student> allStudents = studentService.getAllStudents();
        return allStudents;
    }

    @GetMapping("/api/schools")
    public List<School> listschools() {
        List<School> allSchools = schoolService.getAllSchool();
        return allSchools;
    }

    @PostMapping("/api/countries")
    public Country saveCountry(@RequestBody Country country) {

        Country cn = new Country();
        cn.setCountry(country.getCountry());
        cn.setId(country.getId());
        Country save = countryService.saveCountry(cn);
        return save;
    }

    @PostMapping("/api/schools")
    public School saveSchool(@RequestBody School school) {
        School sc = new School();
       // Country cn = new Country();
        sc.setId(school.getId());
        sc.setName(school.getName());
        sc.setCountry(school.getCountry());
        School save = schoolService.saveSchools(sc);
        return save;
    }

    @PostMapping("/api/schools/{id}")
    public School updateSchool(@PathVariable Long id, @RequestBody School school) {
        School existingSchool = schoolService.getSchoolById(id);
        existingSchool.setId(id);
        existingSchool.setName(school.getName());
        Country country = countryService.getById(school.getCountry().getId());
         existingSchool.setCountry(country);
        School update = schoolService.updateSchool(existingSchool);
        return update;
    }

    @GetMapping("/api/schools/{id}")
    public School getSchool(@PathVariable Long id) {
        School sc = schoolService.getSchoolById(id);
        return sc;
    }

    @GetMapping("/api/students/{id}")
    public Student getStudents(@PathVariable Long id) {
        Student st = studentService.getStudentById(id);
        return st;
    }

    @PostMapping("/api/students")
    public Student saveStudents(@RequestBody Student student) {

        Student save = studentService.saveStudent(student);
        return save;
    }

    @PostMapping("/api/students/{id}")
    public Student updateStudents(@PathVariable Long id,@RequestBody Student student) {

        Student update = studentService.updateStudent(id,student);
        return update;

    }
}
