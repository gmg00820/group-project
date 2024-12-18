package com.example.com.controller;

import com.example.com.domain.CNMT;
import com.example.com.domain.PST;
import com.example.com.service.CNMTService;
import com.example.com.service.PSTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
public class PSTViewController {

    private final PSTService pstService;
    private final CNMTService cnmtService;

    @Autowired
    public PSTViewController(PSTService pstService, CNMTService cnmtService) {
        this.pstService = pstService;
        this.cnmtService = cnmtService;
    }

    // BB_NO 값으로 게시글 목록 조회
    @GetMapping
    public String getPostsByBBNo(@RequestParam("bbNo") Integer bbNo, Model model) {
        // 게시글 목록 가져오기
        List<PST> posts = pstService.getPostsByBBNo(bbNo);
        String boardType = (bbNo == 1) ? "공지사항" : "자유게시판";

        // 댓글 데이터는 특정 게시글 선택 시 제공
        List<CNMT> comments = null;
        if (!posts.isEmpty()) {
            comments = cnmtService.getCommentsByPostId(posts.get(0).getPstId());
        }

        // 모델에 데이터 전달
        model.addAttribute("posts", posts);
        model.addAttribute("comments", comments);
        model.addAttribute("boardType", boardType);

        return "posts"; // posts.html 템플릿 반환
    }



    // 게시글 작성 폼
    @GetMapping("/add")
    public String addPostForm(Model model) {
        model.addAttribute("post", new PST());
        return "addPost";
    }

    // 게시글 작성
    @PostMapping("/add")
    public String addPost(@ModelAttribute PST pst) {
        pstService.addPost(pst);
        return "redirect:/board?bbNo=" + pst.getBbInfo().getBbNo();
    }
}
