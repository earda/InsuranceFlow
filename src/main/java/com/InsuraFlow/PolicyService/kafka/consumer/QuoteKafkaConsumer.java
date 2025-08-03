package com.InsuraFlow.PolicyService.kafka.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.InsuraFlow.PolicyService.kafka.event.QuoteCreatedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class QuoteKafkaConsumer {

    private final ObjectMapper objectMapper;

    public QuoteKafkaConsumer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "quote-created", groupId = "policy-service-group")
    public void consume(String message) {
        try {
            QuoteCreatedEvent event = objectMapper.readValue(message, QuoteCreatedEvent.class);
            System.out.println("Yeni teklif alındı (Kafka): " + event);

            // TODO: Gerekirse otomatik policy oluştur veya logla

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}