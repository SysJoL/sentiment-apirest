package com.sentiment.demo.client;

import com.sentiment.demo.dto.SentimentRequest;
import com.sentiment.demo.dto.SentimentResponse;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class SentimentApiClient {

    private static final String FASTAPI_URL = "http://localhost:8000/sentiment";
    private final RestTemplate restTemplate;

    public SentimentApiClient() {
        this.restTemplate = new RestTemplate();
    }

    public SentimentResponse predecir(SentimentRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<SentimentRequest> entity = new HttpEntity<>(request, headers);

        ResponseEntity<SentimentResponse> response = restTemplate.exchange(
                FASTAPI_URL,
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
