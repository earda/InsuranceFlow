package com.InsuraFlow.PolicyService.mapper;

import com.InsuraFlow.PolicyService.dto.PolicyRequestDto;
import com.InsuraFlow.PolicyService.dto.PolicyResponseDto;
import com.InsuraFlow.PolicyService.model.Policy;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-05T17:24:03+0300",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.40.0.v20240919-1711, environment: Java 17.0.12 (Eclipse Adoptium)"
)
@Component
public class PolicyMapperImpl implements PolicyMapper {

    @Override
    public Policy toEntity(PolicyRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Policy policy = new Policy();

        policy.setPolicyNumber( dto.getPolicyNumber() );
        policy.setQuoteId( dto.getQuoteId() );
        policy.setStartDate( dto.getStartDate() );
        policy.setEndDate( dto.getEndDate() );
        policy.setTotalPremium( dto.getTotalPremium() );

        return policy;
    }

    @Override
    public PolicyResponseDto toDto(Policy entity) {
        if ( entity == null ) {
            return null;
        }

        PolicyResponseDto policyResponseDto = new PolicyResponseDto();

        policyResponseDto.setId( entity.getId() );
        policyResponseDto.setPolicyNumber( entity.getPolicyNumber() );
        policyResponseDto.setStartDate( entity.getStartDate() );
        policyResponseDto.setEndDate( entity.getEndDate() );
        policyResponseDto.setTotalPremium( entity.getTotalPremium() );

        return policyResponseDto;
    }
}
