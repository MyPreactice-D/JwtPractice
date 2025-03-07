package com.example.jwtpractice.auth.service;

import com.example.jwtpractice.auth.dto.SignUpResponseDto;
import com.example.jwtpractice.auth.dto.SignUprequestDto;
import com.example.jwtpractice.auth.dto.SigninRequestDto;
import com.example.jwtpractice.auth.dto.SigninResponseDto;
import com.example.jwtpractice.config.JwtFilter;
import com.example.jwtpractice.config.JwtUtil;
import com.example.jwtpractice.config.PasswordEncoder;
import com.example.jwtpractice.user.entity.User;
import com.example.jwtpractice.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Transactional
    public SignUpResponseDto signup(SignUprequestDto signUprequestDto) {
        if (userRepository.existsByEmail(signUprequestDto.getEmail())) {
            throw new IllegalArgumentException("이메일이 이미 중복됨");
        }

        String encodePassword = passwordEncoder.encode(signUprequestDto.getPassword()); // 보안을 위해서 암호화
        User user = new User(encodePassword, signUprequestDto.getEmail());
        userRepository.save(user);
        return new SignUpResponseDto(user.getId(), user.getEmail());
    }

    public SigninResponseDto signin(SigninRequestDto signinRequestDto) {
        User user = userRepository.findByEmail(signinRequestDto.getEmail()).orElseThrow(
                () -> new IllegalArgumentException("사용자가 없습니다.")
        );

        if (!passwordEncoder.matches(signinRequestDto.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지않습니다.");
        }

        String barerToken = jwtUtil.createToken(user.getId(), user.getEmail());

        return new SigninResponseDto(barerToken);
    }
}
