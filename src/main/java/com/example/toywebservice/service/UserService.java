package com.example.toywebservice.service;

import com.example.toywebservice.model.UserEntity;
import com.example.toywebservice.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserEntity create(final UserEntity entity) {
        if (entity == null || entity.getEmail() == null) {
            throw new RuntimeException("Invalid arguments");
        }
        final String email = entity.getEmail();
        if (userRepository.existsByEmail(email)) {
            throw new RuntimeException("Email already exists");
        }
        return userRepository.save(entity);
    }

    public UserEntity getByCredentials(final String email, final String password,
                                       final PasswordEncoder encoder) {
        final UserEntity originaluser = userRepository.findByEmail(email);

        if (originaluser != null &&
                encoder.matches(password, originaluser.getPassword())) {
            return originaluser;
        }
        return null;
    }
}
