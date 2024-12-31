package com.example.counsel.controller;

import com.example.counsel.entity.ProgramApplication;
import com.example.counsel.service.ProgramApplicationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/program")
public class ProgramApplicationController {

    private final ProgramApplicationService service;

    public ProgramApplicationController(ProgramApplicationService service) {
        this.service = service;
    }

    // 모든 프로그램 신청 정보 조회
    @GetMapping("/applications")
    public List<ProgramApplication> getAllApplications() {
        return service.findAllApplications();
    }

    // 프로그램 신청 등록
    @PostMapping("/applications")
    public ProgramApplication createApplication(@RequestBody ProgramApplication application) {
        return service.saveApplication(application);
    }
}
