package com.InsuraFlow.PolicyService.service.impl;

import com.InsuraFlow.PolicyService.dto.PolicyRequestDto;
import com.InsuraFlow.PolicyService.dto.PolicyResponseDto;
import com.InsuraFlow.PolicyService.mapper.PolicyMapper;
import com.InsuraFlow.PolicyService.model.Policy;
import com.InsuraFlow.PolicyService.repository.PolicyRepository;
import com.InsuraFlow.PolicyService.service.PolicyService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

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
    public PolicyResponseDto createPolicy(PolicyRequestDto dto) {
        Policy policy = policyMapper.toEntity(dto);
        policy.setPolicyNumber(UUID.randomUUID().toString());
        Policy saved = policyRepository.save(policy);
        return policyMapper.toDto(saved);
    }

    @Override
    public PolicyResponseDto getPolicyById(Long id) {
        return policyRepository.findById(id)
                .map(policyMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Policy not found"));
    }
}
