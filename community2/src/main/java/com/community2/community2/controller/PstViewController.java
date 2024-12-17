package com.community2.community2.controller;

import com.community2.community2.domain.PST;
import com.community2.community2.dto.PstViewListResponse;
import com.community2.community2.service.PstService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@RequiredArgsConstructor
@Controller
public class PstViewController {

    private final PstService pstService;

    @GetMapping("/posts")
    public String getPosts(Model model){
//        List<PstViewListResponse> posts =  pstService.getAllPosts().stream()
//                .map(PstViewListResponse::new)
//                .toList();
        List<PST> posts = pstService.findAll();
        model.addAttribute("posts", posts);
        return "postList";
    }


}
//package com.community2.community2.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class PstViewController {
//
//    @GetMapping("/posts-view")
//    public String showPostsView() {
//        // templates/posts.html을 반환
//        return "posts";
//    }
//}

