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
public class BB_INFO {

    @Id
    @Column(name="BB_NO")
    @OneToMany(mappedBy = "BB_NO")
    private int BB_NO; // 게시판 종류(공지사항, 자유게시판을 위해 사용)

    @Column(name = "BB_SE")
    private String BB_SE; //게시판 구분(공지사항, 자유게시판)

    @Column(name = "BB_NM")
    private String BB_NM;
}
