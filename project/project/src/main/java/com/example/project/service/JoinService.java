package com.example.project.service;

import com.example.project.dto.JoinDTO;
import com.example.project.entity.UserEntity;
import com.example.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class JoinService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void joinProcess(JoinDTO joinDTO) {
        // 동일한 username(LGN_ID)을 가진 회원이 이미 있는지 확인
        if (userRepository.findByUsername(joinDTO.getUsername()) != null) {
            throw new IllegalStateException("이미 존재하는 사용자입니다.");
        }

        UserEntity data = new UserEntity();

        // 데이터 설정
        data.setUserNo("U" + System.currentTimeMillis()); // USER_NO: 임의로 생성
        data.setUserSe("GENERAL"); // USER_SE: 일반 사용자
        data.setUsername(joinDTO.getUsername());
        data.setPassword(bCryptPasswordEncoder.encode(joinDTO.getPassword()));
        data.setPasswordChangeDate(LocalDateTime.now());
        data.setPasswordErrorCount(0);
        data.setLastLoginDate(LocalDateTime.now());
        data.setSocialId(""); // 소셜 ID 비우기
        data.setAccessToken("");
        data.setRefreshToken("");

        // 데이터 저장
        userRepository.save(data);
    }
}