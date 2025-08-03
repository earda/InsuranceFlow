package com.InsuraFlow.QuatoService.mapper;

import com.InsuraFlow.QuatoService.dto.QuoteRequestDto;
import com.InsuraFlow.QuatoService.model.Quote;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-03T16:39:17+0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
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
