package com.InsuraFlow.PolicyService.mapper;

import com.InsuraFlow.PolicyService.dto.PolicyRequestDto;
import com.InsuraFlow.PolicyService.dto.PolicyResponseDto;
import com.InsuraFlow.PolicyService.model.Policy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PolicyMapper {
    Policy toEntity(PolicyRequestDto dto);
    PolicyResponseDto toDto(Policy entity);
}
