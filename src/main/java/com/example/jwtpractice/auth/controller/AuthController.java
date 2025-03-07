package com.example.jwtpractice.auth.controller;

import com.example.jwtpractice.auth.dto.SignUpResponseDto;
import com.example.jwtpractice.auth.dto.SignUprequestDto;
import com.example.jwtpractice.auth.dto.SigninRequestDto;
import com.example.jwtpractice.auth.dto.SigninResponseDto;
import com.example.jwtpractice.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/auth/signup")
    public SignUpResponseDto signUp(@RequestBody SignUprequestDto signUprequestDto) {
        return authService.signup(signUprequestDto);
    }

    @PostMapping("/auth/signin")
    public SigninResponseDto signIn(@RequestBody SigninRequestDto signinRequestDto) {
        return authService.signin(signinRequestDto);
    }
}
