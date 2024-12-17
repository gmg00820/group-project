package com.community2.community2.dto;

import com.community2.community2.domain.PST;

public class PstViewListResponse {
    private final int id;
    private final String pstTtl;
    private final String pstCn;

    public PstViewListResponse(PST pst){
        this.id = pst.getPstId();
        this.pstTtl = pst.getPstTtl();
        this.pstCn = pst.getPstCn();
    }

}
