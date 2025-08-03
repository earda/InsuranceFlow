package com.InsuraFlow.InsuraFlow.mapper;

import com.InsuraFlow.InsuraFlow.dto.QuoteRequestDto;
import com.InsuraFlow.InsuraFlow.model.Quote;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuoteMapper {

    Quote toEntity(QuoteRequestDto dto);
}
