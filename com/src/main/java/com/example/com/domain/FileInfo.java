package com.example.com.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "FILE_INFO")
public class FileInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FILE_NO")
    private Integer fileNo; // 파일 번호

    @Column(name = "SEQ_NO", nullable = false)
    private String seqNo; // 파일 순서 번호

    @Column(name = "UUID")
    private String uuid; // 파일 UUID

    @Column(name = "ORG_FILE_NM")
    private String orgFileNm; // 원본 파일명

    @Column(name = "FILE_PATH")
    private String filePath; // 파일 경로
}
