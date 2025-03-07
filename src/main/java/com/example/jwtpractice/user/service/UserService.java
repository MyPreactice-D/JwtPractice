package com.example.jwtpractice.user.service;

import com.example.jwtpractice.config.PasswordEncoder;
import com.example.jwtpractice.user.dto.PasswordUpdateRequestDto;
import com.example.jwtpractice.user.dto.PasswordUpdateResponseDto;
import com.example.jwtpractice.user.dto.UserResponseDto;
import com.example.jwtpractice.user.entity.User;
import com.example.jwtpractice.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    
    @Transactional(readOnly = true)
    public List<UserResponseDto> findAll() {
        List<User> users = userRepository.findAll();
        List<UserResponseDto> dtos = new ArrayList<>();

        for (User user : users) {
            dtos.add(new UserResponseDto(user.getId(), user.getEmail()));
        }
        
        return dtos;
    }

    @Transactional
    public PasswordUpdateResponseDto updatePassword(Long id,
                                                    PasswordUpdateRequestDto passwordUpdateRequestDto) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("사용자가 존재하지않습니다.")
        );
        if (!passwordEncoder.matches(passwordUpdateRequestDto.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지않습니다.");
        }
        user.passwordUpdate(passwordUpdateRequestDto.getNewPassword());

        return new PasswordUpdateResponseDto(user.getId(), user.getEmail());
    }
}
