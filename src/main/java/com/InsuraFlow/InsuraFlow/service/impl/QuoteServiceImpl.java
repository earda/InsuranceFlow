package com.InsuraFlow.InsuraFlow.service.impl;

import com.InsuraFlow.InsuraFlow.dto.QuoteRequestDto;
import com.InsuraFlow.InsuraFlow.mapper.QuoteMapper;
import com.InsuraFlow.InsuraFlow.model.Quote;
import com.InsuraFlow.InsuraFlow.repository.QuoteRepository;
import com.InsuraFlow.InsuraFlow.service.QuoteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuoteServiceImpl implements QuoteService {

    private final QuoteRepository quoteRepository;
    private final QuoteMapper quoteMapper;

    public QuoteServiceImpl(QuoteRepository quoteRepository, QuoteMapper quoteMapper) {
        this.quoteRepository = quoteRepository;
        this.quoteMapper = quoteMapper;
    }
    @Override
    public Quote createQuote(QuoteRequestDto quoteRequestDto) {
        Quote quote = quoteMapper.toEntity(quoteRequestDto);
        return quoteRepository.save(quote);
    }

    @Override
    public Quote getQuoteById(Long id) {
        return quoteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Quote not found with id: " + id));
    }

    @Override
    public List<Quote> getAllQuotes() {
        return quoteRepository.findAll();
    }

    @Override
    public void deleteQuote(Long id) {
        quoteRepository.deleteById(id);
    }
}
