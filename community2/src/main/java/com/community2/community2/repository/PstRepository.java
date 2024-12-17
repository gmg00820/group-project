package com.community2.community2.repository;

import com.community2.community2.domain.PST;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PstRepository extends JpaRepository<PST, Integer> {
}
