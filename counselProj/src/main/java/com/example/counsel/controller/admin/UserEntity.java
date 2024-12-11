package com.example.counsel.controller.admin;
/**
 * 사용자 정보 저장 클래스
 */
public class UserEntity {
    private Long id; // 사용자 고유 ID
    private String name; // 사용자 이름
    private String password; // 사용자 비밀번호
    private String email; // 사용자 이메일
    private String contact; // 사용자 연락처
    private String address; // 사용자 주소

        // 생성자
        public UserEntity(Long id, String name, String password, String email, String contact, String address) {
            this.id = id;
            this.name = name;
            this.password = password;
            this.email = email;
            this.contact = contact;
            this.address = address;
        }

        // Getter & Setter
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getContact() {
            return contact;
        }

        public void setContact(String contact) {
            this.contact = contact;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }
