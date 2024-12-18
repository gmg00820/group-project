package com.example.com.service;

import com.example.com.domain.PST;
import com.example.com.repository.PSTRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PSTService {

    private final PSTRepository pstRepository;

    @Autowired
    public PSTService(PSTRepository pstRepository) {
        this.pstRepository = pstRepository;
    }

    // BB_NO 기준으로 게시글 조회
    public List<PST> getPostsByBBNo(Integer bbNo) {
        List<PST> posts = pstRepository.findByBbInfo_BbNo(bbNo);
        if (posts == null || posts.isEmpty()) {
            throw new IllegalArgumentException("No posts found for BB_NO: " + bbNo);
        }
        return posts;
    }


    // 게시글 추가
    public PST addPost(PST pst) {
        return pstRepository.save(pst);
    }

    // 게시글 삭제
    public void deletePost(Integer pstId) {
        pstRepository.deleteById(pstId);
    }
}
