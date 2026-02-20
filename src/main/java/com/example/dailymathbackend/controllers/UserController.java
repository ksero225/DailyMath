package com.example.dailymathbackend.controllers;

import com.example.dailymathbackend.domain.dto.RegisterRequestDto;
import com.example.dailymathbackend.domain.dto.RegisterResponseDto;
import com.example.dailymathbackend.domain.entity.UserEntity;
import com.example.dailymathbackend.services.interfaces.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/register")
    public ResponseEntity<RegisterResponseDto> createUser(@Valid @RequestBody RegisterRequestDto request) {
        RegisterResponseDto userEntity = userService.save(request);
    }
}
