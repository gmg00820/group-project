package com.example.com.domain;

import com.example.com.domain.PST;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "CNMT")
public class CNMT {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CNMT_ID")
    private Integer cnmtId; // 댓글 ID

    @Column(name = "CNMT_CN", nullable = false)
    private String cnmtCn; // 댓글 내용

    @Column(name = "WRT_NM", nullable = false)
    private String wrtNm; // 작성자 이름

    @Column(name = "CNMT_WRT_DT")
    private LocalDateTime cnmtWrtDt; // 댓글 작성일

    @Column(name = "CNMT_MDFCN_DT")
    private LocalDateTime cnmtMdfcnDt; // 댓글 수정일

    @ManyToOne
    @JoinColumn(name = "PST_ID", nullable = false)
    private PST pst; // 댓글이 속한 게시글
}
