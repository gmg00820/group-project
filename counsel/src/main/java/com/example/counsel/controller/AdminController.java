package com.example.counsel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/admin/login")

public class AdminController {

    @GetMapping("/admin-main")
    public String adminPage() {

        return "admin-main"; // 관리자 메인 페이지 반환
    }
}