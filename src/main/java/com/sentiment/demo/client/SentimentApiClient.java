package com.sentiment.demo.client;

import com.sentiment.demo.dto.SentimentRequest;
import com.sentiment.demo.dto.SentimentResponse;
import org.springframework.beans.factory.annotation.Value; // Importante
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SentimentApiClient {

    // Ahora leemos la URL desde las propiedades
    private final String fastapiUrl;
    private final RestTemplate restTemplate;

    // Inyectamos el valor a través del constructor o directamente en el campo
    public SentimentApiClient(@Value("${python.api.url}") String fastapiUrl) {
        this.fastapiUrl = fastapiUrl;
        this.restTemplate = new RestTemplate();
    }

    public SentimentResponse predecir(SentimentRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<SentimentRequest> entity = new HttpEntity<>(request, headers);

        // Usamos la variable 'fastapiUrl' que viene de Render o Local
        ResponseEntity<SentimentResponse> response = restTemplate.exchange(
                fastapiUrl,
                HttpMethod.POST,
                entity,
                SentimentResponse.class
        );

        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            throw new RuntimeException("Error al conectar con FastAPI: " + response.getStatusCode());
        }
    }
}