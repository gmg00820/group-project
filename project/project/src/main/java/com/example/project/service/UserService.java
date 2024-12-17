package com.example.project.service;

import com.example.project.dto.UpdateUserDTO;
import com.example.project.entity.StudentEntity;
import com.example.project.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private StudentRepository studentRepository; // StudentRepository 사용

    public void updateStudent(String studentNo, UpdateUserDTO updateUserDTO) {
        StudentEntity studentEntity = studentRepository.findByStudentNo(studentNo);
        if (studentEntity == null) {
            throw new IllegalArgumentException("Student not found with ID: " + studentNo);
        }

        // 업데이트 데이터 적용
        if (updateUserDTO.getPassword() != null) {
            studentEntity.setPassword(updateUserDTO.getPassword()); // 평문 비밀번호
        }
        if (updateUserDTO.getEmail() != null) {
            studentEntity.setEmail(updateUserDTO.getEmail());
        }
        if (updateUserDTO.getAddress() != null) {
            studentEntity.setAddress(updateUserDTO.getAddress());
        }
        if (updateUserDTO.getPhoneNumber() != null) {
            studentEntity.setMobileNumber(updateUserDTO.getPhoneNumber());
        }

        studentRepository.save(studentEntity);
    }
}
