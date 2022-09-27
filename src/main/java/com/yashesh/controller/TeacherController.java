package com.yashesh.controller;

import com.yashesh.entity.Teacher;
import com.yashesh.repository.TeacherRepository;
import com.yashesh.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TeacherController {

    private TeacherService teacherService;
    private TeacherRepository teacherRepository;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/teachers")
    public String listTeachers(Model model) {
        model.addAttribute("teachers",teacherService.getAllTeachers());
        return "teachers";
    }




}
