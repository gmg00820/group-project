package com.example.counsel.dto;

import com.example.counsel.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BoardListResponseDTO {
    // 제목
    private String title;

    // 작성자명
    private String username;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;

    // Entity -> DTO
    public BoardListResponseDTO(Board board) {
        if (board == null) {
            throw new IllegalArgumentException("Board entity cannot be null");
        }
        this.title = board.getTitle();
        this.username = board.getUsername(); // 작성자명 추가
        this.createdAt = board.getCreatedAt(); // 올바르게 매핑
        this.modifiedAt = board.getModifiedAt();
    }
}
