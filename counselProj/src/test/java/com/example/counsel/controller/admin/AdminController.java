package com.example.counsel.controller.admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private  IBoardService service;

    @Autowired
    private  IUserService UserService;

    @Autowired ICommentService comService;

    @GetMapping("/admin_main")
    private void main(Model model){
        System.out.println("메인 페이지로 이동");
        model.addAttribute("boardList", service.getAdminList());
        model.addAttribute("userInfo", UserService.adminUserList());
    }
}
