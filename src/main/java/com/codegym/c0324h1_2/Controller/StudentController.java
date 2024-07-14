package com.codegym.c0324h1_2.Controller;

import com.codegym.c0324h1_2.models.Student;
import com.codegym.c0324h1_2.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private IStudentService studentService;

@GetMapping("/student")
    public String displayStudent(Model model) {
    List<Student> students = studentService.findAll();
    model.addAttribute("students", students);
    return "student/list";
    }
}
