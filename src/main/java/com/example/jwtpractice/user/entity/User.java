package com.example.jwtpractice.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;

    public User(String password, String email) {
        this.password = password;
        this.email = email;
    }

    public void passwordUpdate(String newPassword) {
        this.password = password;
    }
}
