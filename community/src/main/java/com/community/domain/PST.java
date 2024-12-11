package com.community.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class PST {

    @Id
    @Column(name="PST_ID")
    @OneToMany(mappedBy = "PST_ID")
    private int PST_ID;

    @ManyToOne
    @JoinColumn(name = "BB_NO")
    private Long BB_NO; // 게시판 번호

    @Column(name = "PST_TTL", nullable = false)
    private String PST_TTL; //글 제목

    @Column(name = "PST_CN", nullable = false)
    private String PST_CN; //글 내용

    @Column(name = "WRT_NM")
    private String WRT_NM4; //작성자 성명

    @Column(name ="PST_WRT_DT")
    private String PST_WRT_DT; //게시글 작성일

    @Column(name = "PST_MDFCN_DT")
    private String PST_MDFCN_DT; //게시글 수정일

    @Column(name = "INQ_CNT")
    private Long INQ_CNT; // 조회수

    @ManyToOne
    @JoinColumn(name = "USER_NO")
    private String USER_NO; //외래키 사용자 번호 -> 작성자 번호

    @ManyToOne
    @JoinColumn(name = "FILE_NO")
    private Long FILE_NO;




}
