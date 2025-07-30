package com.InsuraFlow.InsuraFlow.repository;

import com.InsuraFlow.InsuraFlow.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Long> {
}
