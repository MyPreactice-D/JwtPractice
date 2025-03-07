package com.example.jwtpractice.auth.dto;

import lombok.Getter;

@Getter
public class SigninResponseDto {
    private final String barerToken;

    public SigninResponseDto(String barerToken) {
        this.barerToken = barerToken;
    }
}
