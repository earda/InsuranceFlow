package com.InsuraFlow.InsuraFlow;

import org.springframework.boot.SpringApplication;

public class TestInsuranceApplication {

	public static void main(String[] args) {
		SpringApplication.from(InsuranceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
