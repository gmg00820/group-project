package com.example.project.controller;

import com.example.project.entity.RequestEntity;
import com.example.project.service.RequestService;

import com.example.project.userdetails.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/requests")
public class RequestController {

    @Autowired
    private RequestService requestService;

    // 학생의 상담 신청 현황 출력
    @GetMapping
    public String getStudentRequests(@AuthenticationPrincipal CustomUserDetails userDetails, Model model) {
        // 로그인한 사용자의 studentNo 가져오기
        String studentNo = userDetails.getStudentNo(); // CustomUserDetails에서 studentNo 가져오기

        // `studentNo`를 기준으로 데이터 조회
        List<RequestEntity> requests = requestService.getRequsetBySTDNNTNO(studentNo);

        // 모델에 데이터 추가
        model.addAttribute("requests", requests);

        // 요청 리스트 뷰로 이동
        return "requests/list";
    }
}
