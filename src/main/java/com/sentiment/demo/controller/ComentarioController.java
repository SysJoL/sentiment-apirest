package com.sentiment.demo.controller;

import com.sentiment.demo.dto.ComentarioRequestDTO;
import com.sentiment.demo.dto.ComentarioResponseDTO;
import com.sentiment.demo.dto.MetricsDTO;
import com.sentiment.demo.service.ComentarioService;
import com.sentiment.demo.service.MetricsService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comentarios")
@CrossOrigin(origins = "*")
public class ComentarioController {

    private final ComentarioService service;
    private final MetricsService metricsService;

    public ComentarioController(ComentarioService service, MetricsService metricsService) {
        this.service = service;
        this.metricsService = metricsService; // [cite: 32]
    }

    @PostMapping
    public ComentarioResponseDTO crear(
            @Valid @RequestBody ComentarioRequestDTO request) {
        return service.procesarComentario(request);
    }

    @GetMapping
    public Page<ComentarioResponseDTO> list(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return service.listarPaginado(page, size);
    }



    @GetMapping("/metrics") // URL: http://localhost:8080/api/comentarios/metrics
    public MetricsDTO getMetrics() {
        return metricsService.getMetrics(); //
    }

    @GetMapping("/ejemplos")
    public List<ComentarioResponseDTO> getEjemplos() {
        return service.obtenerEjemplosAleatorios();
    }
}
