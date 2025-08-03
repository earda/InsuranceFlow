package com.InsuraFlow.PolicyService.service.impl;

import com.InsuraFlow.PolicyService.dto.PolicyRequestDto;
import com.InsuraFlow.PolicyService.dto.PolicyResponseDto;
import com.InsuraFlow.PolicyService.mapper.PolicyMapper;
import com.InsuraFlow.PolicyService.model.Policy;
import com.InsuraFlow.PolicyService.repository.PolicyRepository;
import com.InsuraFlow.PolicyService.service.PolicyService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class PolicyServiceImpl implements PolicyService {

    private final PolicyRepository policyRepository;
    private final PolicyMapper policyMapper;

    public PolicyServiceImpl(PolicyRepository policyRepository, PolicyMapper policyMapper) {
        this.policyRepository = policyRepository;
        this.policyMapper = policyMapper;
    }

    @Override
    @Transactional
    public Policy createPolicy(PolicyRequestDto dto) {
        Policy policy = new Policy();

        policy.setQuoteId(dto.getQuoteId());
        policy.setStartDate(dto.getStartDate());
        policy.setEndDate(dto.getEndDate());
        policy.setTotalPremium(dto.getTotalPremium());

        // Otomatik policy numarası üret
        policy.setPolicyNumber(UUID.randomUUID().toString());

        // Veritabanına kaydet
        Policy savedPolicy = policyRepository.save(policy);

        // İstenirse burada Kafka mesajı gönderilebilir:
        // örnek olarak:
    /*
    PolicyCreatedEvent event = new PolicyCreatedEvent(
        savedPolicy.getId(),
        savedPolicy.getQuoteId(),
        savedPolicy.getPolicyNumber()
    );
    policyKafkaProducer.sendPolicyCreatedEvent(event);
    */

        return savedPolicy;
    }

    @Override
    public List<Policy> getAllPolicies() {
        return policyRepository.findAll();
    }
    @Override
    public PolicyResponseDto getPolicyById(Long id) {
        return policyRepository.findById(id)
                .map(policyMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Policy not found"));
    }
}
