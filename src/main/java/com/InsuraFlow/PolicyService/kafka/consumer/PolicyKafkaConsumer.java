package com.InsuraFlow.PolicyService.kafka.consumer;

import com.InsuraFlow.PolicyService.model.Policy;
import com.InsuraFlow.PolicyService.repository.PolicyRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.InsuraFlow.PolicyService.kafka.event.PolicyCreatedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Service
public class PolicyKafkaConsumer {

    private final ObjectMapper objectMapper;
    private final PolicyRepository policyRepository;

    public PolicyKafkaConsumer(ObjectMapper objectMapper, PolicyRepository policyRepository) {
        this.objectMapper = objectMapper;
        this.policyRepository = policyRepository;
    }

    @KafkaListener(topics = "quote-created", groupId = "policy-service-group")
    public void consume(String message) {
        try {
            PolicyCreatedEvent event = objectMapper.readValue(message, PolicyCreatedEvent.class);
            System.out.println("Yeni teklif alındı (Kafka): " + event);

            // 🔧 Otomatik Policy kaydı
            Policy policy = new Policy();
            policy.setQuoteId(event.getQuoteId());
            policy.setPolicyNumber(UUID.randomUUID().toString());
            policy.setStartDate(LocalDate.now());
            policy.setEndDate(LocalDate.now().plusYears(1));
            policy.setTotalPremium(new BigDecimal("2721.00")); // Dummy premium

            policyRepository.save(policy);

            System.out.println("Otomatik policy oluşturuldu: " + policy);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}