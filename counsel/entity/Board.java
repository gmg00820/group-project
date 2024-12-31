package com.example.counsel.entity;

import com.example.counsel.dto.BoardRequestDTO;
import com.example.counsel.dto.Timestamped;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Board extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String username; // 작성자명 추가

    public Board (BoardRequestDTO requestDTO) {
        this.title = requestDTO.getTitle();
        this.content = requestDTO.getContent();
        this.password = requestDTO.getPassword();
        this.username = requestDTO.getUsername(); // 작성자명 저장
    }

    public void update(BoardRequestDTO requestDTO) {
        this.title = requestDTO.getTitle();
        this.content = requestDTO.getContent();
        this.password = requestDTO.getPassword();
        this.username = requestDTO.getUsername(); // 작성자명 업데이트
    }
}
