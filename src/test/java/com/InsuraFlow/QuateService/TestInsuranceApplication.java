package com.InsuraFlow.QuateService;

import org.springframework.boot.SpringApplication;

public class TestInsuranceApplication {

	public static void main(String[] args) {
		SpringApplication.from(InsuranceQuoteApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
