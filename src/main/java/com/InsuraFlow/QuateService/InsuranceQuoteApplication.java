package com.InsuraFlow.QuatoService;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication(scanBasePackages = "com.InsuraFlow")
public class InsuranceQuoteApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(InsuranceQuoteApplication.class)
				.properties("spring.config.location=classpath:/quoteservice/application.properties")
				.run(args);
	}

}
