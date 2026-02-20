package com.example.dailymathbackend.services.implementation;

import com.example.dailymathbackend.domain.dto.RegisterRequestDto;
import com.example.dailymathbackend.domain.dto.RegisterResponseDto;
import com.example.dailymathbackend.domain.entity.UserEntity;
import com.example.dailymathbackend.jwt.JwtService;
import com.example.dailymathbackend.repositories.UserRepository;
import com.example.dailymathbackend.services.interfaces.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @Override
    public RegisterResponseDto save(RegisterRequestDto request) {
        if (userRepository.existsByUserEmail(request.mail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already exists");
        }

        if (userRepository.existsByUserLogin(request.login())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Login already exists");
        }

        UserEntity newUser = UserEntity.builder()
                .userEmail(request.mail())
                .userLogin(request.login())
                .userPasswordHash(passwordEncoder.encode(request.password()))
                .build();

        UserEntity savedUser = userRepository.save(newUser);

        String token = jwtService.generateToken(
                org.springframework.security.core.userdetails.User
                        .withUserDetails(savedUser.getUserLogin())
                        .password(savedUser.getUserPasswordHash())
        )

        return RegisterResponseDto.builder().token().email(newUser.getUserEmail()).build();
    }
}
