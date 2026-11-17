package com.Monolitic.monolitic.dto;

import jakarta.validation.constraints.*;

public record ApplicationRequest(

        @NotBlank(message = "Name is required")
        String name,

        @NotNull(message = "Age is required")
        @Min(1)
        @Max(120)
        Integer age,

        @NotBlank
        @Email
        String email

) {}