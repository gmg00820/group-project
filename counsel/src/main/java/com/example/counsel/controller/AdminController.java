package com.example.counsel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/login")
    public String adminLoginPage() {
        return "adminlogin"; // 관리자 로그인 페이지 템플릿
    }

    @GetMapping("/main")
    public String adminMainPage() {
        return "adminmain"; // 관리자 메인 페이지 템플릿
    }
}
