package com.example.project.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "USER_INFO")
public class UserEntity {

    @Id
    @Column(name = "USER_NO")
    private String userNo;

    @Column(name = "USER_SE")
    private String userSe;

    @Column(name = "LGN_ID")
    private String username; // 매핑: LGN_ID

    @Column(name = "PSWD")
    private String password; // 매핑: PSWD

    @Column(name = "PSWD_CHG_DT")
    private LocalDateTime passwordChangeDate;

    @Column(name = "PSWD_ERR_NMTN")
    private int passwordErrorCount;

    @Column(name = "LAST_LGN_DT")
    private LocalDateTime lastLoginDate;

    @Column(name = "SOCIAL_ID")
    private String socialId;

    @Column(name = "ACCESS_TOKEN")
    private String accessToken;

    @Column(name = "REFRESH_TOKEN")
    private String refreshToken;

    // Getters and Setters
    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getUserSe() {
        return userSe;
    }

    public void setUserSe(String userSe) {
        this.userSe = userSe;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getPasswordChangeDate() {
        return passwordChangeDate;
    }

    public void setPasswordChangeDate(LocalDateTime passwordChangeDate) {
        this.passwordChangeDate = passwordChangeDate;
    }

    public int getPasswordErrorCount() {
        return passwordErrorCount;
    }

    public void setPasswordErrorCount(int passwordErrorCount) {
        this.passwordErrorCount = passwordErrorCount;
    }

    public LocalDateTime getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(LocalDateTime lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public String getSocialId() {
        return socialId;
    }

    public void setSocialId(String socialId) {
        this.socialId = socialId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
