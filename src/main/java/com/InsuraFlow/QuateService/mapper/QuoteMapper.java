package com.InsuraFlow.QuatoService.mapper;

import com.InsuraFlow.QuatoService.dto.QuoteRequestDto;
import com.InsuraFlow.QuatoService.model.Quote;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuoteMapper {

    Quote toEntity(QuoteRequestDto dto);
}
