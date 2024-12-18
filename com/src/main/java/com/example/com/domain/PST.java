package com.example.com.domain;

import com.example.com.domain.BBInfo;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "PST")
public class PST {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PST_ID")
    private Integer pstId;

    @ManyToOne
    @JoinColumn(name = "BB_NO", nullable = false)
    private BBInfo bbInfo;

    @Column(name = "PST_TTL")
    private String pstTtl;

    @Column(name = "PST_CN", columnDefinition = "LONGTEXT")
    private String pstCn;

    @Column(name = "WRT_NM")
    private String wrtNm;

    @Column(name = "PST_WRT_DT")
    private LocalDateTime pstWrtDt;

    @Column(name = "PST_MDFCN_DT")
    private LocalDateTime pstMdfcnDt;

    @Column(name = "INQ_CNT")
    private Integer inqCnt;

    @Column(name = "STTS")
    private String stts;
}
