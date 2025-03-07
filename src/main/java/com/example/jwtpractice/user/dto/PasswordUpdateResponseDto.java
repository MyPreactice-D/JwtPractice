package com.example.jwtpractice.user.dto;

import lombok.Getter;

@Getter
public class PasswordUpdateResponseDto {
    private final Long id;
    private final String email;

    public PasswordUpdateResponseDto(Long id, String email) {
        this.id = id;
        this.email = email;
    }
}
