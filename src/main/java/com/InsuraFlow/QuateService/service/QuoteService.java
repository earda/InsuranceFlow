package com.InsuraFlow.QuatoService.service;

import com.InsuraFlow.QuatoService.dto.QuoteRequestDto;
import com.InsuraFlow.QuatoService.model.Quote;

import java.util.List;

public interface QuoteService {
    Quote createQuote(QuoteRequestDto quoteRequestDto);
    Quote getQuoteById(Long id);
    List<Quote> getAllQuotes();
    void deleteQuote(Long id);
}
