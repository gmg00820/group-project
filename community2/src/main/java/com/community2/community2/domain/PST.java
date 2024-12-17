package com.community2.community2.domain;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.File;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class PST {

    @Id
    @Column(name="PST_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pstId; // 수정

    @ManyToOne
    @JoinColumn(name = "BB_NO")
    private BBInfo bbNo; // Board 엔티티로 변경

    @Column(name = "PST_TTL", nullable = false)
    private String pstTtl; // 수정

    @Column(name = "PST_CN", nullable = false)
    private String pstCn; // 수정

    @Column(name = "WRT_NM")
    private String wrtNm; // 수정

    @Column(name = "PST_WRT_DT")
    @CreatedDate
    private LocalDateTime pstWrtDt; // LocalDateTime으로 변경

    @Column(name = "PST_MDFCN_DT")
    @LastModifiedDate
    private LocalDateTime pstMdfcnDt; // LocalDateTime으로 변경

    @Column(name = "INQ_CNT")
    private int inqCnt; // 수정

    @ManyToOne
    @JoinColumn(name = "USER_NO")
    private UserInfo user; // User 엔티티로 변경

    @ManyToOne
    @JoinColumn(name = "FILE_NO", referencedColumnName = "FILE_NO")
    private FileInfo fileNo; // File 엔티티로 변경

    @Builder
    public PST(String wrtNm, String pstTtl, String pstCn) {
        this.wrtNm = wrtNm;
        this.pstTtl = pstTtl;
        this.pstCn = pstCn;
    }

}

