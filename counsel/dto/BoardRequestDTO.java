package com.example.counsel.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class BoardRequestDTO {

    private String title;

    private String content;

    private String password;

    private String username;
}