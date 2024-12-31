package com.example.counsel.repository;

import com.example.counsel.entity.Board;
import com.example.counsel.dto.BoardListResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<BoardListResponseDTO> findAllByOrderByModifiedAtDesc();
}