package com.example.counsel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/admin")d

public class AdminLoginController {

    @GetMapping("/admin/login")
    public String AdminloginPage() {

        return "adminlogin"; //관리자 로그인 페이지 반환
    }
}

