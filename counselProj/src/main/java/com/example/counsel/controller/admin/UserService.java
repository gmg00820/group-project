package com.example.counsel.controller.admin;

import org.springframework.stereotype.Service;

@Service
public class UserService {


        private final UserRepository userRepository;

    //의존성 주입 - UserRepository를 통해 데이터 액세스
        public UserService(UserRepository userRepository) {
            this.userRepository = userRepository;
        }

        // 사용자 정보 가져오기
        public UserEntity getUserById(Long id) {
            return userRepository.findById(id);
        }

        // 비밀번호 변경
        public boolean changePassword(Long userId, String oldPassword, String newPassword) {
            UserEntity user = userRepository.findById(userId);// 사용자 정보 조회
            if (user != null && user.getPassword().equals(oldPassword)) {// 기존 비밀번호 확인
                user.setPassword(newPassword); // 비밀번호 변경
                userRepository.save(user);// 변경된 사용자 정보 저장
                return true; // 성공
            }
            return false; //실패
        }

        // 개인정보 수정
        public void updateUserInfo(Long userId, String email, String contact, String address) {
            UserEntity user = userRepository.findById(userId);
            if (user != null) {
                user.setEmail(email); //이메일업데이트
                user.setContact(contact);//전화번호업데이트
                user.setAddress(address);//주소업데이트
                userRepository.save(user);//저장
            }
        }
    }

