package com.community2.community2.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "CNMT")
public class CNMT {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 생성 전략 추가
    @Column(name = "CNMT_ID")
    private int cnmtId; // 댓글 ID

    @Column(name = "CNMT_CN")
    private String cnmtCn; // 댓글 내용

    @Column(name = "WRT_NM")
    private String wrtNm; // 작성자 성명

    @Column(name = "CNMT_WRT_DT")
    private String cnmtWrtDt; // 댓글 작성일

    @Column(name = "CNMT_MDFCN_DT")
    private String cnmtMdfcnDt; // 댓글 수정일

    @ManyToOne
    @JoinColumn(name = "PST_ID")
    private PST pstId; // Post 엔티티 참조

    @ManyToOne
    @JoinColumn(name = "USER_NO")
    private UserInfo userNo; // User 엔티티 참조

    @ManyToOne
    @JoinColumn(name = "BB_NO")
    private BBInfo bbNo; // BBInfo 엔티티 참조
}

