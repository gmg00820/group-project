package com.example.com.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "USER_INFO")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_NO")
    private Integer userNo; // 사용자 번호

    @Column(name = "LGN_ID")
    private String lgnId; // 로그인 ID

    @Column(name = "PSWD")
    private String pswd; // 비밀번호

    @Column(name = "PSWD_CHG_DT")
    private LocalDateTime pswdChgDt; // 비밀번호 변경일

    @Column(name = "PSWD_ERR_NMTN")
    private Integer pswdErrNmtn; // 비밀번호 오류 횟수

    @Column(name = "LAST_LGN_DT")
    private LocalDateTime lastLgnDt; // 마지막 로그인 일시

    @Column(name = "SOCIAL_ID")
    private String socialId; // 소셜 ID

    @Column(name = "ACCESS_TOKEN")
    private String accessToken; // 액세스 토큰

    @Column(name = "REFRESH_TOKEN")
    private String refreshToken; // 리프레시 토큰

    @Column(name = "USER_SE")
    private String userSe; // 사용자 구분

    @Column(name = "2FA_SECRET")
    private String twoFaSecret; // 2FA 비밀키

    @Column(name = "2FA_ACTVTN_YN")
    private Character twoFaActvtnYn; // 2FA 활성화 여부
}
