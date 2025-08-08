package com.InsuraFlow.QuateService.mapper;

import com.InsuraFlow.QuateService.dto.QuoteRequestDto;
import com.InsuraFlow.QuateService.model.Quote;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuoteMapper {

    Quote toEntity(QuoteRequestDto dto);
}
