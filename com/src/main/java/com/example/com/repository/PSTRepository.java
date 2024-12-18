package com.example.com.repository;

import com.example.com.domain.PST;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PSTRepository extends JpaRepository<PST, Integer> {
    // BB_NO 값을 기준으로 게시글 조회
    List<PST> findByBbInfo_BbNo(Integer bbNo);
}
