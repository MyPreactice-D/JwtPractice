package com.example.jwtpractice.user.dto;

import lombok.Getter;

@Getter
public class PasswordUpdateRequestDto {
    private String password;
    private String newPassword;
}
