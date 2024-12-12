package com.example.counsel.controller.admin;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue; // Change this line
import jakarta.persistence.GenerationType; // And this line
import lombok.Getter;
import lombok.Setter;

/**
 * 사용자 정보 저장 클래스
 */
@Getter
@Setter
@Entity
public class UserEntity {
    // Getter & Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 사용자 고유 ID
    private String name; // 사용자 이름
    private String password; // 사용자 비밀번호
    private String email; // 사용자 이메일
    private String contact; // 사용자 연락처
    private String address; // 사용자 주소

    // 기본 생성자
    public UserEntity() {
    }

    // 생성자
    public UserEntity(Long id,String name, String password, String email, String contact, String address) {
        this.id=id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.contact = contact;
        this.address = address;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
