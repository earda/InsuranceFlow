package com.InsuraFlow.PolicyService;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication(scanBasePackages = "com.InsuraFlow.PolicyService")
public class InsurancePolicyApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(InsurancePolicyApplication.class)
                .properties("spring.config.location=classpath:/policyservice/application.properties")
                .run(args);
    }


}
