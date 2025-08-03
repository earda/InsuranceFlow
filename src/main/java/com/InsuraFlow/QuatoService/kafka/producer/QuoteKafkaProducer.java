package com.InsuraFlow.QuatoService.kafka.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.InsuraFlow.QuatoService.kafka.event.QuoteCreatedEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class QuoteKafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    private static final String TOPIC = "quote-created";

    public QuoteKafkaProducer(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public void sendQuoteCreatedEvent(QuoteCreatedEvent event) {
        try {
            String message = objectMapper.writeValueAsString(event);
            kafkaTemplate.send(TOPIC, message);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Kafka mesajı serileştirme hatası", e);
        }
    }
}