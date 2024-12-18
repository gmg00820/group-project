package com.example.com.service;

import com.example.com.domain.CNMT;
import com.example.com.repository.CNMTRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CNMTService {

    private final CNMTRepository cnmtRepository;

    @Autowired
    public CNMTService(CNMTRepository cnmtRepository) {
        this.cnmtRepository = cnmtRepository;
    }

    // 특정 게시글의 댓글 조회
    public List<CNMT> getCommentsByPostId(Integer pstId) {
        return cnmtRepository.findByPst_PstId(pstId);
    }

    // 댓글 추가
    public CNMT addComment(CNMT comment) {
        comment.setCnmtWrtDt(LocalDateTime.now());
        comment.setCnmtMdfcnDt(LocalDateTime.now());
        return cnmtRepository.save(comment);
    }

    // 댓글 수정
    public CNMT updateComment(Integer commentId, CNMT updatedComment) {
        CNMT existingComment = cnmtRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("Comment not found: " + commentId));
        existingComment.setCnmtCn(updatedComment.getCnmtCn());
        existingComment.setCnmtMdfcnDt(LocalDateTime.now());
        return cnmtRepository.save(existingComment);
    }

    // 댓글 삭제
    public void deleteComment(Integer commentId) {
        cnmtRepository.deleteById(commentId);
    }
}
