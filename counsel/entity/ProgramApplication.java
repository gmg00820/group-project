package com.example.counsel.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class ProgramApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String boardType;        // 게시판 종류
    private String taskType;         // 생성 업무
    private Integer number;          // 번호
    private String title;            // 제목
    @Lob
    private String content;          // 내용
    private String writerName;       // 작성자 이름
    private String writerDepartment; // 작성 부서
    private LocalDateTime createdAt; // 작성 일시
    private Integer viewCount;       // 조회수
    private String scope;            // 조회 범위
    private String taskScope;        // 조회 업무
    private String filePath;         // 첨부 파일 경로
}
