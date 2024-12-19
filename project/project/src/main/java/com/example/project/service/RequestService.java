package com.example.project.service;

import com.example.project.entity.RequestEntity;
import com.example.project.repository.CounselorRepository;
import com.example.project.repository.RequestRepository;
import com.example.project.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CounselRequest {
    @Autowired
    private RequestRepository requestRepository;




    @Transactional
    public void Requst(RequestRepository requsetrepository ){
        this.requestRepository = requestRepository;
    }
public List<RequestEntity> getRequsetBySTDNNTNO(String studentNo) {
    return requestRepository.findBySTDNNTN(studentNo);
}
}
