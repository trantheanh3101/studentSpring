package com.codegym.c0324h1_2.Controller;

import com.codegym.c0324h1_2.models.Student;
import com.codegym.c0324h1_2.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @GetMapping("")
    public String displayStudent(Model model) {
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        return "student/list";
    }

//    @RequestMapping(value = "/create" , method = RequestMethod.GET)
    @GetMapping(value = "/create")
    public String viewCreate(Model model) {
        model.addAttribute("student",new Student());
//        String[] gender = new String[]{"name","nu"};
//        model.addAttribute("gender",gender);
        return "student/create";
    }

    @PostMapping("/create")
    public String newStudent(@ModelAttribute("student") Student student,
                             BindingResult bindingResult,
                             RedirectAttributes redirect) {
        if (bindingResult.hasFieldErrors()){
            return "student/create";
        }
        studentService.save(student);
        redirect.addFlashAttribute("message", "Thêm mới thành công");
        return "redirect:/student/";
    }

    @GetMapping("/update/{id}")
    public String viewUpdate(@PathVariable Long id,Model model) {
        Student student = studentService.findById(id);
        if (student != null){
            model.addAttribute("student",student);
            return "/student/update";
        }
        return "redirect:/student/";
    }

    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable("id") Long idEdit,
                                @RequestParam("name") String name,
                                @RequestParam("address") String address,
                                @RequestParam("score") Float score,
                                RedirectAttributes redirect) {
        Student studentEdit = studentService.findById(idEdit);
        if (studentEdit != null) {
            studentEdit.setName(name);
            studentEdit.setAddress(address);
            studentEdit.setScore(score);
            studentService.update(idEdit,studentEdit);
            redirect.addFlashAttribute("message", "Cập nhật thành công");
        }
        return "redirect:/student/";
    }
}
