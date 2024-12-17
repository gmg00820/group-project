package com.community2.community2.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@IdClass(FileInfoId.class)
@Table(name = "FILE_INFO")
public class FileInfo {
    @Id
    @Column(name = "FILE_NO")
    private String fileNo; // 수정

    @Id
    @Column(name = "SEQ_NO")
    private String seqNo; // 수정

    @Column(name ="UUID")
    private String uuid; // 수정

    @Column(name = "ORG_FILE_NM")
    private String orgFileNm; // 수정

    @Column(name = "FILE_PATH")
    private String filePath; // 수정
}

