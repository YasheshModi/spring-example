package com.yashesh.controller;

import com.yashesh.entity.Country;
import com.yashesh.entity.Student;
import com.yashesh.entity.Teacher;
import com.yashesh.repository.TeacherRepository;
import com.yashesh.service.CountryService;
import com.yashesh.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TeacherController {

    private TeacherService teacherService;
    private TeacherRepository teacherRepository;
    private CountryService countryService;

    public TeacherController(TeacherService teacherService, CountryService countryService) {
        this.teacherService = teacherService;
        this.countryService = countryService;
    }

    @GetMapping("/teachers")
    public String listTeachers(Model model) {
        model.addAttribute("teachers",teacherService.getAllTeachers());
        return "teachers";
    }

    @GetMapping("/teachers/new")
    public String createTeacherForm(Model model) {
        Teacher teacher = new Teacher();
        model.addAttribute("teacher",teacher);
        model.addAttribute("country",countryService.getAllCountry());
//        Country countryresponse = countryService.findByCountryId(id);
        return "create_teacher";
    }

    @PostMapping("/teachers")
    public String saveTeacher(@ModelAttribute("teacher") Teacher teacher) {
        teacherService.saveTeacher(teacher);
        return "redirect:/teachers";
    }

    @GetMapping("/teachers/{id}")
    public String deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacherById(id);
        return "redirect:/teachers";
    }

    @GetMapping("/teachers/edit/{id}")
   public String editTeacherForm(Model model,@PathVariable Long id) {
        model.addAttribute("teacher",teacherService.getTeacherById(id));
        model.addAttribute("country",countryService.getAllCountry());
        return "edit_teacher";
   }

   @PostMapping("/teachers/{id}")
    public String updateTeacher(@PathVariable Long id,Teacher teacher,Model model) {
        Teacher existingTeacher = teacherService.getTeacherById(id);
        existingTeacher.setId(teacher.getId());
        existingTeacher.setName(teacher.getName());
        existingTeacher.setAge(teacher.getAge());
        existingTeacher.setGender(teacher.getGender());
        existingTeacher.setAddress(teacher.getAddress());
        existingTeacher.setCountry(teacher.getCountry());

        teacherService.updateTeacher(existingTeacher);
        return "redirect:/teachers";
   }



}
