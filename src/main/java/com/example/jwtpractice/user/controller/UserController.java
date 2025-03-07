package com.example.jwtpractice.user.controller;

import com.example.jwtpractice.auth.annotation.Auth;
import com.example.jwtpractice.auth.annotation.AuthUser;
import com.example.jwtpractice.user.dto.PasswordUpdateRequestDto;
import com.example.jwtpractice.user.dto.PasswordUpdateResponseDto;
import com.example.jwtpractice.user.dto.UserResponseDto;
import com.example.jwtpractice.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public List<UserResponseDto> findAll(@Auth AuthUser authUser) {
        return userService.findAll();
    }

    @PatchMapping("/users/password")
    public PasswordUpdateResponseDto updatePassword(@Auth AuthUser authUser,
                                                    @RequestBody PasswordUpdateRequestDto passwordUpdateRequestDto) {
        return userService.updatePassword(authUser.getId(), passwordUpdateRequestDto);
    }
}
