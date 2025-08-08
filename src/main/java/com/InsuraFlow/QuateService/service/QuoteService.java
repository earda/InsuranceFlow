package com.InsuraFlow.QuateService.service;

import com.InsuraFlow.QuateService.dto.QuoteRequestDto;
import com.InsuraFlow.QuateService.model.Quote;

import java.util.List;

public interface QuoteService {
    Quote createQuote(QuoteRequestDto quoteRequestDto);
    Quote getQuoteById(Long id);
    List<Quote> getAllQuotes();
    void deleteQuote(Long id);
}
