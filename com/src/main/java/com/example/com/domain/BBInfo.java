package com.example.com.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "BB_INFO")
public class BBInfo {

    @Id
    @Column(name = "BB_NO")
    private Integer bbNo; // 게시판 번호 (1: 공지사항, 2: 자유게시판)

    @Column(name = "BB_SE")
    private String bbSe; // 게시판 구분

    @Column(name = "BB_NM")
    private String bbNm; // 게시판 이름
}
