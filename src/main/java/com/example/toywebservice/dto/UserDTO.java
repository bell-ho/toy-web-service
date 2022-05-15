package com.example.toywebservice.dto;

import com.example.toywebservice.model.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {


    private String token;

    private String username;

    private String email;

    private String password;

    private String id;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserEntity toEntity() {
        return UserEntity.builder()
                .email(email)
                .username(username)
                .password(passwordEncoder.encode(password))
                .build();
    }
}
