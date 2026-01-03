package com.sentiment.demo.service;

import com.sentiment.demo.client.SentimentApiClient;
import com.sentiment.demo.dto.Prevision;
import com.sentiment.demo.dto.SentimentRequest;
import com.sentiment.demo.dto.SentimentResponse;
import com.sentiment.demo.exception.ModelUnavailableException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class SentimentService {
    private final SentimentApiClient client;

    public SentimentService(SentimentApiClient client) {
        this.client = client;
    }

    public SentimentResponse analizarSentimiento(SentimentRequest request) {
        // Aquí podrías añadir lógica adicional (logs, preprocesamiento, validaciones extra)
        return client.predecir(request);
    }
}
