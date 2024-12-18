package com.example.com.repository;

import com.example.com.domain.CNMT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CNMTRepository extends JpaRepository<CNMT, Integer> {
    // 특정 게시글(PST_ID)의 댓글 조회
    List<CNMT> findByPst_PstId(Integer pstId);
}
