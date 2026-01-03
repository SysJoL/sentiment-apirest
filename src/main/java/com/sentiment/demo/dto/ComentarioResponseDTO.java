package com.sentiment.demo.dto;

import java.time.LocalDateTime;

public record ComentarioResponseDTO(
        Long id,
        String texto,
        Prevision sentimiento,
        double probabilidad,
        LocalDateTime fecha
) {

}
