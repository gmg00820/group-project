package admin.controller;

import admin.util.JwtUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminLoginController {

    // 로그인 POST 요청 처리
    @PostMapping("/admin/login")
    public String handleLogin(@RequestParam("username") String username,
                              @RequestParam("password") String password,
                              Model model) {
        // 예: 유효성 검사
        if ("admin".equals(username) && "password".equals(password)) {
            // JWT를 생성하고 전달
            JwtUtil jwtUtil = new JwtUtil();
            String token = jwtUtil.generateToken(username);
            model.addAttribute("token", token);
            return "redirect:/admin/dashboard"; // 성공 시 대시보드로 리디렉션
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "adminloginform"; // 실패 시 다시 로그인 폼
        }

    }
}
