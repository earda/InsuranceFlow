package com.InsuraFlow.QuatoService.repository;

import com.InsuraFlow.QuatoService.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Long> {
}
