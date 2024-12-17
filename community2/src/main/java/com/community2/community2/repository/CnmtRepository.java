package com.community2.community2.repository;

import com.community2.community2.domain.CNMT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CnmtRepository extends JpaRepository<CNMT, Integer> {

}
