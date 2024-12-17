package com.community2.community2.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "USER_INFO")
public class UserInfo {

    @Id
    @Column(name="USER_NO")
    private int userNo;

    @Column(name="LGN_ID")
    private String lgnId;

    @Column(name = "PSWD")
    private String pswd;

    @Column(name = "PSWD_CHG_DT")
    private LocalDateTime pswdChgDt;

    @Column(name = "PSWD_ERR_NMTN")
    private int pswdErrNmtn;

    @Column(name = "LAST_LGN_DT")
    private LocalDateTime lastLgnDt;

    @Column(name = "SOCIAL_ID")
    private String socialId;

    @Column(name = "ACCESS_TOKEN")
    private String accessToken;

    @Column(name = "REFRESH_TOKEN")
    private String refreshToken;

    @Column(name = "USER_SE")
    private String userSe;

    @Column(name = "2FA_SECRET")
    private String faSecret2;

    @Column(name = "2FA_ACTVTN_YN")
    private Character faActvtnYn2; // Character로 변경
}
