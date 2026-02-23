package com.example.dailymathbackend.domain.dto;

public record LoginResponseDto(
        String token,
        String username,
        String email
) {
}
