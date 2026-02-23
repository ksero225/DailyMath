package com.example.dailymathbackend.services.interfaces;

import com.example.dailymathbackend.domain.dto.LoginRequestDto;
import com.example.dailymathbackend.domain.dto.LoginResponseDto;
import com.example.dailymathbackend.domain.dto.RegisterRequestDto;
import com.example.dailymathbackend.domain.dto.RegisterResponseDto;
import com.example.dailymathbackend.domain.entity.UserEntity;
import jakarta.validation.Valid;

public interface UserService {
    RegisterResponseDto save(@Valid RegisterRequestDto request);

    LoginResponseDto login(@Valid LoginRequestDto request);
}
