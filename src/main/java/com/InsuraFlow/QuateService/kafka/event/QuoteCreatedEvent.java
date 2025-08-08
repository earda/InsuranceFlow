package com.InsuraFlow.QuateService.kafka.event;


import lombok.Data;
@Data
public class QuoteCreatedEvent {
    private Long quoteId;
    private String fullName;
    private String identityNumber;

    public QuoteCreatedEvent() {
    }
    public QuoteCreatedEvent(Long quoteId, String fullName, String identityNumber) {
        this.quoteId = quoteId;
        this.fullName = fullName;
        this.identityNumber = identityNumber;
    }

    public Long getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(Long quoteId) {
        this.quoteId = quoteId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }
}
