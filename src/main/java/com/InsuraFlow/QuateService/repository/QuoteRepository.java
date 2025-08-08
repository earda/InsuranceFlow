package com.InsuraFlow.QuateService.repository;

import com.InsuraFlow.QuateService.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Long> {
}
