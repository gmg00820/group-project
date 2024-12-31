package com.example.counsel.controller;



import org.springframework.ui.Model;
import com.example.counsel.dto.Student;
import com.example.counsel.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/stduent/students") // /student/students로 시작하는 URL요청이 컨트롤러의 메서드로 라우팅되도록 설정.
public class StudentController {
    private final StudentRepository studentRepository;

    @Autowired //의존성 주입
    public StudentController (StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public String students(Model model){
        List<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);
        return "/student/students";
    }

    @GetMapping("/add")
    public String addForm(Model model){
        return "/student/addStudent";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute("student")
                           Student student, RedirectAttributes redirectAttributes){
        Student savedStudent = studentRepository.save(student);

        redirectAttributes.addAttribute("STDNT_NO", savedStudent.getSTDNT_NO());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/stduent/students/{STDNT_NO}";
    }

    @GetMapping("/{STDNT_NO}")
    public String Student(@PathVariable Long STDNT_NO, Model model){
        Student student = studentRepository.findById((STDNT_NO));
        model.addAttribute("student", student);
        return "/student/student";
    }

    @GetMapping("/{STDNT_NO}/edit")
    public String editForm(@PathVariable Long STDNT_NO, Model model){
        Student student = studentRepository.findById((STDNT_NO));
        model.addAttribute("student", student);
        return "/student/studentEditForm";
    }

    @PostMapping("{STDNT_NO}/edit")
    public String edit(@PathVariable Long STDNT_NO, Student student, Model model){
        studentRepository.update(STDNT_NO, student);
        return "redirect:/stduent/students/{STDNT_NO}";
    }
}
