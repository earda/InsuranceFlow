package com.InsuraFlow.InsuraFlow.service;

import com.InsuraFlow.InsuraFlow.dto.QuoteRequestDto;
import com.InsuraFlow.InsuraFlow.model.Quote;

import java.util.List;

public interface QuoteService {
    Quote createQuote(QuoteRequestDto quoteRequestDto);
    Quote getQuoteById(Long id);
    List<Quote> getAllQuotes();
    void deleteQuote(Long id);
}
