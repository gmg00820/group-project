package com.example.counsel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/adminlogin")
    public String adminLoginP() {
        return "adminlogin";
    }

    @GetMapping("/adminmain")
    public String adminMainP() {
        return "adminmain";
    }
}
