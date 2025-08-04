package com.InsuraFlow.PolicyService.service;

import com.InsuraFlow.PolicyService.dto.PolicyRequestDto;
import com.InsuraFlow.PolicyService.dto.PolicyResponseDto;
import com.InsuraFlow.PolicyService.model.Policy;

import java.util.List;

public interface PolicyService {
    Policy createPolicy(PolicyRequestDto dto);
    PolicyResponseDto getPolicyById(Long id);

    List<Policy> getAllPolicies();
}
