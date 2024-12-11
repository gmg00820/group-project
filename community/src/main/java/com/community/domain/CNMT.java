package com.community.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name ="CNMT")
public class CNMT {

    @Id
    @Column(name ="CNMT_ID")
    private int CNMT_ID; // 댓글 ID

    @Column(name = "CNMT_CN")
    private String CNME_CN; // 댓글 내용

    @Column(name = "WRT_NM")
    private String WRT_NM; // 작성자 성명

    @Column(name = "CNMT_WRT_DT")
    private String CNMT_WRT_DT; // 댓글 작성일

    @Column(name = "CNMT_MDFCN_DT")
    private String CNMT_MDFCN_DT; //댓글 수정일

    @ManyToOne
    @JoinColumn(name="PST_ID")
    private int PST_ID;

    @ManyToOne
    @JoinColumn(name="USER_NO")
    private String USER_NO;

    @ManyToOne
    @JoinColumn(name="BB_NO")
    private Long BB_NO;
}
