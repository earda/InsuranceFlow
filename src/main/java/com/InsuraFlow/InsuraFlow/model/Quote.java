package com.InsuraFlow.InsuraFlow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String identityNumber;
    private LocalDate birthDate;
    private String gender;
    private String phoneNumber;
    private String email;

    private LocalDateTime createdAt;
}
