package com.community2.community2.service;


import com.community2.community2.domain.PST;
import com.community2.community2.dto.PstAddRequest;
import com.community2.community2.repository.PstRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PstService {
    private final PstRepository pstRepository;



    @Autowired
    public PstService(PstRepository pstRepository) {
        this.pstRepository = pstRepository;
    }

    public PST save(PstAddRequest request){
        return pstRepository.save(request.toEntity());
    }

    public List<PST> findAll(){
        return pstRepository.findAll();
    }

    public PST findById(int userNo){
        return pstRepository.findById(userNo).orElseThrow(() -> new IllegalArgumentException("찾을 수 없습니다."));
    }


}
