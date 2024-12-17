package com.community2.community2.dto;

import com.community2.community2.domain.PST;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PstAddRequest {
    private String pstTtl;
    private String pstCn;

    public PST toEntity(){
        return PST.builder()
                .pstTtl(pstTtl)
                .pstCn(pstCn)
                .build();
    }
}
