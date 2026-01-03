package com.sentiment.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ComentarioRequestDTO(
        @NotBlank
        @Size(min = 5, max = 2000)
        String texto
) {
}
