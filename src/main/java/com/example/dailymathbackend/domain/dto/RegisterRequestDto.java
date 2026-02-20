package com.example.dailymathbackend.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterRequestDto(
        @NotBlank @Email @Size(max = 320) String mail,
        @NotBlank @Size(min = 8, max = 320) String password,
        @NotBlank @Size(min = 3, max = 50) String login
) { }
