package com.example.dailymathbackend.domain.dto;

import lombok.Builder;

@Builder
public record RegisterResponseDto(
        String token,
        String username,
        String email
) {
}
