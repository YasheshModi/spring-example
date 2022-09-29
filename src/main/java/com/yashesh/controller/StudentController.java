package com.yashesh.controller;

import com.yashesh.entity.Country;
import com.yashesh.entity.Student;
import com.yashesh.repository.StudentRepository;
import com.yashesh.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {
    private StudentService studentService;
    private StudentRepository studentRepository;
    private CountryService countryService;
    private SchoolService schoolService;

    public StudentController(StudentService studentService,CountryService countryService,SchoolService schoolService) {
        super();
        this.studentService = studentService;
        this.countryService = countryService;
        this.schoolService = schoolService;
    }

    @GetMapping("/students")
    public String liststudents(Model model)
    {
        model.addAttribute("students",studentService.getAllStudents());
        model.addAttribute("country",countryService.getAllCountry());
        return "students";
    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model) {
        // create student object to hold student form data
        Student student = new Student();
        model.addAttribute("student", student);
        model.addAttribute("country",countryService.getAllCountry());
        model.addAttribute("school", schoolService.getAllSchool());
        return "create_student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        model.addAttribute("country", countryService.getAllCountry());
        model.addAttribute("school", schoolService.getAllSchool());
        return "edit_student";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id,@ModelAttribute("student") Student student,Model model) {

        // get student from database by id
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setSchool(student.getSchool());
        existingStudent.setCountry(student.getCountry());
        // save updated student object
        studentService.updateStudent(existingStudent);
        return "redirect:/students";
    }

    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }

    @PostMapping("/searchfname")
    public String searchByFirstName(Model model,@RequestParam("firstName") String firstName) {
        if(firstName!=null) {
            List<Student> list = studentService.getByFirstName(firstName);
            model.addAttribute("students", list);
        }
        else {
            List<Student> list = studentService.getAllStudents();
            model.addAttribute("students", list);
        }
        return "students";
    }

    @PostMapping("/searchlname")
    public String searchByLastName(Model model, @RequestParam("lastName") String lastName){
        if(lastName!=null) {
            List<Student> list = studentService.getByLastName(lastName);
            model.addAttribute("students",list);
        }
        return "students";
    }

    @PostMapping("/searchemail")
    public String searchByEmail(Model model,String email) {
        if(email!=null) {
            List<Student> list = studentService.getByEmail(email);
            model.addAttribute("students",list);
        }
        return "students";
    }

    @PostMapping("/searchcountry")
    public String searchByCountry(Model model, Country country){
        if(country!=null) {
            List<Student> list = studentService.getByCountry(country);
            model.addAttribute("students",list);
        }
        return "students";
    }
    /* @GetMapping("/students/{first_name}/{last_name}")
    public String searchStudentByName(@PathVariable String first_name,@PathVariable String last_name){
        studentRepository.findByFirstNameOrLastName(first_name,last_name);
        return "students";
    }

    @GetMapping("/students/{email}")
    public String searchStudentByEmail(@PathVariable String email) {
        studentRepository.findByEmail(email);
        return "students";
    }*/
}