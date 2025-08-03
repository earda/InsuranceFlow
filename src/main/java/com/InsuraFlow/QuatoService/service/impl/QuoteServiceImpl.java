package com.InsuraFlow.QuatoService.service.impl;

import com.InsuraFlow.QuatoService.dto.QuoteRequestDto;
import com.InsuraFlow.QuatoService.kafka.event.QuoteCreatedEvent;
import com.InsuraFlow.QuatoService.kafka.producer.QuoteKafkaProducer;
import com.InsuraFlow.QuatoService.mapper.QuoteMapper;
import com.InsuraFlow.QuatoService.model.Quote;
import com.InsuraFlow.QuatoService.repository.QuoteRepository;
import com.InsuraFlow.QuatoService.service.QuoteService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuoteServiceImpl implements QuoteService {

    private final QuoteRepository quoteRepository;
    private final QuoteMapper quoteMapper;

    private final QuoteKafkaProducer quoteKafkaProducer;
    public QuoteServiceImpl(QuoteRepository quoteRepository, QuoteMapper quoteMapper, QuoteKafkaProducer quoteKafkaProducer) {
        this.quoteRepository = quoteRepository;
        this.quoteMapper = quoteMapper;
        this.quoteKafkaProducer = quoteKafkaProducer;
    }


    @Override
    @Transactional
    public Quote createQuote(QuoteRequestDto quoteRequestDto) {
        Quote quote = new Quote();
            quote.setFullName(quoteRequestDto.getFullName());
            quote.setIdentityNumber(quoteRequestDto.getIdentityNumber());
            quote.setBirthDate(quoteRequestDto.getBirthDate());
            quote.setGender(quoteRequestDto.getGender());
            quote.setPhoneNumber(quoteRequestDto.getPhoneNumber());
            quote.setEmail(quoteRequestDto.getEmail());
        Quote savedQuote = quoteRepository.save(quote);

        // Kafka mesajı gönderiliyor
        QuoteCreatedEvent event = new QuoteCreatedEvent(
                savedQuote.getId(),
                savedQuote.getFullName(),
                savedQuote.getIdentityNumber()
        );
        quoteKafkaProducer.sendQuoteCreatedEvent(event);

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
