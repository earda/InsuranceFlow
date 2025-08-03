package com.InsuraFlow.PolicyService.kafka.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.InsuraFlow.PolicyService.kafka.event.PolicyCreatedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PolicyKafkaConsumer {

    private final ObjectMapper objectMapper;

    public PolicyKafkaConsumer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "quote-created", groupId = "policy-service-group")
    public void consume(String message) {
        try {
            PolicyCreatedEvent event = objectMapper.readValue(message, PolicyCreatedEvent.class);
            System.out.println("Yeni teklif alındı (Kafka): " + event);

            // TODO: Gerekirse otomatik policy oluştur veya logla

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}