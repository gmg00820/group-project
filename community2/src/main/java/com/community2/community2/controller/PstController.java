//package com.community2.community2.controller;
//import com.community2.community2.domain.PST;
//import com.community2.community2.dto.PostResponse;
//import com.community2.community2.dto.PstAddRequest;
//import com.community2.community2.service.PstService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
////@RequiredArgsConstructor
//public class PstController {
//    private final PstService pstService;
//
//    @Autowired
//    public PstController(PstService pstService) {
//        this.pstService = pstService;
//    }
//
//    @GetMapping("/api/posts")
//    public List<PST> getAllPosts() {
//        return pstService.getAllPosts();
//    }
//
////    @PostMapping("/api/posts")
////    public ResponseEntity<PST> addPst(@RequestBody PstAddRequest
////                                              request){
////        PST savedPst = pstService.save(request);
////        return ResponseEntity.status(HttpStatus.CREATED)
////                .body(savedPst);
////
////    }
////
////
////    @GetMapping("/api/post")
////    public ResponseEntity<List<PostResponse>> findAllPst(){
////        List<PostResponse> PstList =pstService.findAll()
////                .stream()
////                .map(PostResponse::new)
////                .toList();
////        return  ResponseEntity.ok().body(PstList);
////    }
////
////    @GetMapping("/api/posts/{userNo}")
////    public ResponseEntity<PostResponse> findPst(@PathVariable int userNo){
////        PST pst = pstService.findById(userNo);
////
////        return ResponseEntity.ok().body(new PostResponse(pst));
////    }
//}

package com.community2.community2.controller;

import com.community2.community2.domain.PST;
import com.community2.community2.service.PstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PstController {

    private final PstService pstService;

    @Autowired
    public PstController(PstService pstService) {
        this.pstService = pstService;
    }

    @GetMapping("/api/posts")
    public List<PST> getAllPosts() {
        return pstService.findAll();
    }


}
