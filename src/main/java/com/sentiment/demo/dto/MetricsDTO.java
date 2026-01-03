package com.sentiment.demo.dto;

public record MetricsDTO(
        long totalComentarios,
        long positivos,
        long negativos,
        long neutros
) {
}
