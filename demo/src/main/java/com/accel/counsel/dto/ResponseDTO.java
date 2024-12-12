package com.accel.counsel.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseDTO {
    private String error; // 오류 메시지를 저장
}
