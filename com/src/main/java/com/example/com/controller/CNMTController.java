package com.example.com.controller;

import com.example.com.domain.CNMT;
import com.example.com.service.CNMTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CNMTController {

    private final CNMTService cnmtService;

    @Autowired
    public CNMTController(CNMTService cnmtService) {
        this.cnmtService = cnmtService;
    }

    // 특정 게시글의 댓글 조회
    @GetMapping
    public List<CNMT> getCommentsByPostId(@RequestParam("pstId") Integer pstId) {
        return cnmtService.getCommentsByPostId(pstId);
    }

    // 댓글 추가
    @PostMapping
    public CNMT addComment(@RequestBody CNMT comment) {
        return cnmtService.addComment(comment);
    }

    // 댓글 수정
    @PutMapping("/{commentId}")
    public CNMT updateComment(@PathVariable Integer commentId, @RequestBody CNMT updatedComment) {
        return cnmtService.updateComment(commentId, updatedComment);
    }

    // 댓글 삭제
    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable Integer commentId) {
        cnmtService.deleteComment(commentId);
    }
}
