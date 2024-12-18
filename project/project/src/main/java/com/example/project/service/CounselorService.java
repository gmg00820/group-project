package com.example.project.service;

import com.example.project.dto.UpdateUserDTO;
import com.example.project.entity.CounselorEntity;
import com.example.project.entity.UserEntity;
import com.example.project.repository.CounselorRepository;
import com.example.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CounselorService {

    @Autowired
    private CounselorRepository counselorRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void updateCounselor(String userNo, UpdateUserDTO updateUserDTO) {

        // UserEntity 조회 (userNo 기준)
        UserEntity userEntity = userRepository.findByUsername(userNo);
        if (userEntity == null) {
            throw new IllegalArgumentException("User not found with USER_NO: " + userNo);
        }

        // CounselorEntity 조회
        CounselorEntity counselorEntity = counselorRepository.findByUser_UserNo(userEntity.getUserNo());
        if (counselorEntity == null) {
            throw new IllegalArgumentException("Counselor not found with USER_NO: " + userEntity.getUserNo());
        }

        // 비밀번호 업데이트 (평문 저장)
        if (updateUserDTO.getPassword() != null && !updateUserDTO.getPassword().isEmpty()) {
            userEntity.setPassword(updateUserDTO.getPassword());
        }

        // 이메일 업데이트
        if (updateUserDTO.getEmail() != null && !updateUserDTO.getEmail().isEmpty()) {
            counselorEntity.setEmail(updateUserDTO.getEmail());
        }

        // 주소 업데이트
        if (updateUserDTO.getAddress() != null && !updateUserDTO.getAddress().isEmpty()) {
            counselorEntity.setAddress(updateUserDTO.getAddress());
        }

        // 전화번호 업데이트
        if (updateUserDTO.getPhoneNumber() != null) {
            counselorEntity.setMobileNumber(updateUserDTO.getPhoneNumber());
        }

        // 저장소에 업데이트된 정보 저장
        userRepository.save(userEntity);
        counselorRepository.save(counselorEntity);
    }
}
