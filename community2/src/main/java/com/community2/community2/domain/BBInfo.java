package com.community2.community2.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "BB_INFO")
public class BBInfo {

    @Id
    @Column(name = "BB_NO")
    private String bbNo; // 게시판 종류(공지사항, 자유게시판을 위해 사용)

    @Column(name = "BB_SE")
    private String bbSe; // 게시판 구분(공지사항, 자유게시판)

    @Column(name = "BB_NM")
    private String bbNm;

//    // BBInfo는 여러 개의 게시글(Post)을 가질 수 있음
//    @OneToMany(mappedBy = "bbInfo") // Post 엔티티에서 참조하는 필드 이름
//    private List<PST> posts; // 게시글 리스트
}
