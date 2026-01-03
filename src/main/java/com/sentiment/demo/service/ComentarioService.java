package com.sentiment.demo.service;

import com.sentiment.demo.dto.ComentarioRequestDTO;
import com.sentiment.demo.dto.ComentarioResponseDTO;
import com.sentiment.demo.dto.SentimentRequest;
import com.sentiment.demo.entity.Comentario;
import com.sentiment.demo.mapper.ComentarioMapper;
import com.sentiment.demo.repository.ComentarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor // <--- LOMBOK: Genera el constructor para repository y sentimentService
public class ComentarioService {

    private final ComentarioRepository repository;
    private final SentimentService sentimentService;
    private final ComentarioMapper comentarioMapper;

    @Transactional // <--- Agregado: Asegura que el análisis y el guardado sean una sola unidad
    public ComentarioResponseDTO procesarComentario(ComentarioRequestDTO request) {

        // 1. Analizar sentimiento (Usa el texto del DTO de entrada)
        var sentiment = sentimentService.analizarSentimiento(
                new SentimentRequest(request.texto())
        );

        // 2. Crear entidad usando BUILDER
        Comentario comentario = Comentario.builder()
                .texto(request.texto())
                .sentimiento(sentiment.prevision())
                .probabilidad(sentiment.probabilidad())
                .fecha(LocalDateTime.now())
                .build();

        // 3. Guardar en Postgres
        Comentario guardado = repository.save(comentario);

        // 4. Mapear a DTO de respuesta
        return comentarioMapper.toDTO(guardado);
    }

    public Page<ComentarioResponseDTO> listarPaginado(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("fecha").descending());
        return repository.findAll(pageable)
                .map(comentarioMapper::toDTO); // Usando el mapper de MapStruct
    }

    public List<ComentarioResponseDTO> obtenerEjemplosAleatorios() {
        return Stream.of("POSITIVO", "NEUTRO", "NEGATIVO")
                .map(s -> repository.findRandomBySentimiento(s)
                        .map(comentarioMapper::toDTO)
                        .orElse(null))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}