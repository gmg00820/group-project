package com.example.counsel.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String rootRedirect() {
        return "redirect:/login"; // 기본 경로에서 로그인 페이지로 리다이렉트
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("message", "환영합니다! 대시보드입니다.");
        return "dashboard"; // 대시보드 페이지
    }

    @GetMapping("/login")
    public String loginPage(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("error", "로그인에 실패했습니다. 다시 시도해주세요.");
        }
        return "login"; // 로그인 페이지
    }

    @PostMapping("/change-password")
    public String changePassword(
            @RequestParam("userId") Long userId,
            @RequestParam("oldPassword") String oldPassword,
            @RequestParam("newPassword") String newPassword,
            Model model) {
        boolean success = userService.changePassword(userId, oldPassword, newPassword);
        if (success) {
            return "redirect:/user/edit-info";
        } else {
            model.addAttribute("error", "현재 비밀번호가 올바르지 않습니다.");
            return "change-password";
        }
    }

    @GetMapping("/edit-info")
    public String editUserInfo(@RequestParam("userId") Long userId, Model model) {
        UserEntity user = userService.getUserById(userId);
        model.addAttribute("user", user);
        return "edit-info";
    }
}
