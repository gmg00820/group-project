package com.example.counsel.service;

import com.example.counsel.dto.BoardRequestDTO;
import com.example.counsel.dto.BoardListResponseDTO;
import com.example.counsel.dto.BoardResponseDTO;
import com.example.counsel.entity.Board;
import com.example.counsel.repository.BoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;


    // 업데이트 메서드
    public Long update(Long id, BoardRequestDTO requestDTO) {
        // ID로 Board 찾기
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Board not found with id: " + id));

        // 요청된 데이터로 엔티티 업데이트
        board.update(requestDTO);

        // 엔티티 저장
        boardRepository.save(board);

        return board.getId();
    }
    //삭제 메서드
    public Long delete(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Board not found with id: " + id));
        boardRepository.delete(board);
        return id;
    }

    // 글 생성
    public BoardResponseDTO createBoard(BoardRequestDTO requestDTO) {
        // 1. Board -> Entity로 변환
        Board board = new Board();
        // 2. DB에 저장
        boardRepository.save(board);
        // 3. Entity -> ResponseDTO 변환 후 리턴
        return new BoardResponseDTO(board);
    }

    // 모든 글 가져오기
    public List<BoardListResponseDTO> findAllBoard() {
        try{
            List<Board> boardList = boardRepository.findAll();

            List<BoardListResponseDTO> responseDtoList = new ArrayList<>();

            for (Board board : boardList) {
                responseDtoList.add(
                        new BoardListResponseDTO(board)
                );
            }
            return responseDtoList;
        } catch (Exception e) {
//            throw new DBEmptyDataException("a");
        }
        return null;
    }

    // 글 하나 가져오기
    public BoardResponseDTO findOneBoard(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("조회 실패")
        );
        return new BoardResponseDTO(board);
    }

    // 글 수정
    @Transactional
    public Long updateBoard(Long id, BoardRequestDTO requestDTO) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        board.update(requestDTO);
        return board.getId();
    }

    // 삭제
    @Transactional
    public Long deleteBoard(Long id) {
        boardRepository.deleteById(id);
        return id;
    }
}

