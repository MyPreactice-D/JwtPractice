package com.example.jwtpractice.auth.dto;

import lombok.Getter;

@Getter
public class SigninRequestDto {
    private String email;
    private String password;
}
