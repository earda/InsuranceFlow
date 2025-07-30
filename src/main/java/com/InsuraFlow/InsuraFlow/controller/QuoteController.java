package com.InsuraFlow.InsuraFlow.controller;

import com.InsuraFlow.InsuraFlow.dto.QuoteRequestDto;
import com.InsuraFlow.InsuraFlow.model.Quote;
import com.InsuraFlow.InsuraFlow.service.QuoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quotes")
public class QuoteController {

    private final QuoteService quoteService;

    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @PostMapping
    public ResponseEntity<Quote> createQuote(@RequestBody QuoteRequestDto quoteRequestDto) {
        Quote savedQuote = quoteService.createQuote(quoteRequestDto);
        return ResponseEntity.ok(savedQuote);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quote> getQuoteById(@PathVariable Long id) {
        Quote quote = quoteService.getQuoteById(id);
        return ResponseEntity.ok(quote);
    }

    @GetMapping
    public ResponseEntity<List<Quote>> getAllQuotes() {
        List<Quote> quotes = quoteService.getAllQuotes();
        return ResponseEntity.ok(quotes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuote(@PathVariable Long id) {
        quoteService.deleteQuote(id);
        return ResponseEntity.noContent().build();
    }
}
