package com.community2.community2.dto;

import com.community2.community2.domain.PST;
import lombok.Getter;

@Getter
public class PostResponse {
    private int id;
    private String pstTtl;
    private String pstCn;

    public PostResponse(PST pst){
        this.id = pst.getPstId();
        this.pstTtl = pst.getPstTtl();
        this.pstCn = pst.getPstCn();
    }
}
