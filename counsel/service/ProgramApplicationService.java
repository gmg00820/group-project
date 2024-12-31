package com.example.counsel.service;

import com.example.counsel.entity.ProgramApplication;
import com.example.counsel.repository.ProgramApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramApplicationService {

    private final ProgramApplicationRepository repository;

    public ProgramApplicationService(ProgramApplicationRepository repository) {
        this.repository = repository;
    }

    // 프로그램 신청 정보 저장
    public ProgramApplication saveApplication(ProgramApplication application) {
        return repository.save(application);
    }

    // 프로그램 신청 정보 조회
    public List<ProgramApplication> findAllApplications() {
        return repository.findAll();
    }
}
