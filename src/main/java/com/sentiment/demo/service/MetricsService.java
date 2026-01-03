package com.sentiment.demo.service;

import com.sentiment.demo.dto.MetricsDTO;
import com.sentiment.demo.dto.Prevision;
import com.sentiment.demo.repository.ComentarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor // Lombok genera el constructor para el repository
public class MetricsService {

    private final ComentarioRepository repository;

    public MetricsDTO getMetrics() {
        long total = repository.count();

        // Contamos cada uno de forma independiente
        long positivos = repository.countBySentimiento(Prevision.POSITIVO);
        long negativos = repository.countBySentimiento(Prevision.NEGATIVO);
        long neutros = repository.countBySentimiento(Prevision.NEUTRO);

        return new MetricsDTO(total, positivos, negativos, neutros);
    }
}