package com.InsuraFlow.PolicyService.service;

import com.InsuraFlow.PolicyService.dto.PolicyRequestDto;
import com.InsuraFlow.PolicyService.dto.PolicyResponseDto;

public interface PolicyService {
    PolicyResponseDto createPolicy(PolicyRequestDto dto);
    PolicyResponseDto getPolicyById(Long id);
}
