package com.community.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class USER_INFO {

    @Id
    @Column(name="USER_NO")
    @OneToMany(mappedBy="USER_NO")
    private String USER_NO;

    @Column(name="LGN_ID")
    private String LGD_ID;

    @Column(name = "PSWD")
    private String PSWD;

    @Column(name = "PSWD_CHG_DT")
    private String PSWD_CHG_DT;

    @Column(name = "PSWD_ERR_NMTN")
    private int PSWD_ERR_NMTN;

    @Column(name = "LAST_LGN_DT")
    private String LAST_LGN_DT;

    @Column(name = "SOCIAL_ID")
    private String SOCIAL_ID;

    @Column(name = "ACCESS_TOKEN")
    private String ACCESS_TOKEN;

    @Column(name = "REFRESH_TOKEN")
    private String REFRESH_TOKEN;

    @Column(name = "USER_SE")
    private String USER_SE;

    @Column(name = "2FA_SECRET")
    private String FA_SECRET2;

    @Column(name = "2FA_ACTVTN_YN")
    private char FA_ACTVTN_YN2;
}
