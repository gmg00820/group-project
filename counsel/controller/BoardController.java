package com.example.counsel.controller;

import com.example.counsel.dto.BoardListResponseDTO;
import com.example.counsel.dto.BoardRequestDTO;
import com.example.counsel.dto.BoardResponseDTO;
import com.example.counsel.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boards")
public class BoardController {

    private final BoardService boardService;

    // 글 등록
    @PostMapping
    public ResponseEntity<BoardResponseDTO> createBoard(@RequestBody BoardRequestDTO requestDto) {
        BoardResponseDTO response = boardService.createBoard(requestDto);
        return ResponseEntity.ok(response);
    }

    // 전체 목록 조회
    @GetMapping
    public ResponseEntity<List<BoardListResponseDTO>> getAllBoards() {
        List<BoardListResponseDTO> boardList = boardService.findAllBoard();
        return ResponseEntity.ok(boardList);
    }

    // 글 하나 조회
    @GetMapping("/{id}")
    public ResponseEntity<BoardResponseDTO> getOneBoard(@PathVariable Long id) {
        BoardResponseDTO board = boardService.findOneBoard(id);
        return ResponseEntity.ok(board);
    }

    // 글 수정
    @PutMapping("/{id}")
    public ResponseEntity<Long> updateBoard(@PathVariable Long id, @RequestBody BoardRequestDTO requestDTO) {
        Long updatedId = boardService.update(id, requestDTO);
        return ResponseEntity.ok(updatedId);
    }

    // 글 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteBoard(@PathVariable Long id) {
        Long deletedId = boardService.delete(id);
        return ResponseEntity.ok(deletedId);
    }

    // 비밀번호 확인
//    @PostMapping("/check")
//    public ResponseEntity<Boolean> checkPassword(@RequestBody PasswordCheckRequest request) {
//        boolean isValid = boardService.checkPassword(request.getId(), request.getInputPassword());
//        return ResponseEntity.ok(isValid);
//    }
}

class PasswordCheckRequest {
    private Long id;
    private String inputPassword;

}


