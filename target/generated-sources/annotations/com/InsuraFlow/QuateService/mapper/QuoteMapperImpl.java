package com.InsuraFlow.QuatoService.mapper;

import com.InsuraFlow.QuatoService.dto.QuoteRequestDto;
import com.InsuraFlow.QuatoService.model.Quote;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-04T21:01:13+0300",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.40.0.v20240919-1711, environment: Java 17.0.12 (Eclipse Adoptium)"
)
@Component
public class QuoteMapperImpl implements QuoteMapper {

    @Override
    public Quote toEntity(QuoteRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Quote quote = new Quote();

        quote.setFullName( dto.getFullName() );
        quote.setIdentityNumber( dto.getIdentityNumber() );
        quote.setBirthDate( dto.getBirthDate() );
        quote.setGender( dto.getGender() );
        quote.setPhoneNumber( dto.getPhoneNumber() );
        quote.setEmail( dto.getEmail() );

        return quote;
    }
}
