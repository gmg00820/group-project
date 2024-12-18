package com.example.com.controller;

import com.example.com.domain.PST;
import com.example.com.service.PSTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PSTController {

    private final PSTService pstService;

    @Autowired
    public PSTController(PSTService pstService) {
        this.pstService = pstService;
    }

    // BB_NO 값으로 게시글 목록 조회 (공지사항, 자유게시판 등)
    @GetMapping
    public List<PST> getPostsByBBNo(@RequestParam("bbNo") Integer bbNo) {
        return pstService.getPostsByBBNo(bbNo);
    }

    // 게시글 추가
    @PostMapping
    public PST addPost(@RequestBody PST pst) {
        return pstService.addPost(pst);
    }

    // 게시글 삭제
    @DeleteMapping("/{pstId}")
    public void deletePost(@PathVariable Integer pstId) {
        pstService.deletePost(pstId);
    }
}
