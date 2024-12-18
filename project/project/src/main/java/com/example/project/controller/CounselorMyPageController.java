package com.example.project.controller;

import com.example.project.dto.UpdateUserDTO;
import com.example.project.service.CounselorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/counselormypage")
public class CounselorMyPageController {

    @Autowired
    private CounselorService counselorService;

    // 상담사 마이페이지 조회 화면
    @GetMapping
    public String myPageView(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        model.addAttribute("username", userDetails.getUsername());
        return "counselormypage"; // counselormypage.html 반환
    }

    @PostMapping("/coupdate")
    public String updateCounselorInfo(@AuthenticationPrincipal UserDetails userDetails,
                                      UpdateUserDTO updateUserDTO, Model model) {
        String username = userDetails.getUsername();
        counselorService.updateCounselor(username, updateUserDTO);
        model.addAttribute("message", "Counselor information updated successfully.");
        return "redirect:/counselormypage"; // 업데이트 후 리다이렉트
    }
}
