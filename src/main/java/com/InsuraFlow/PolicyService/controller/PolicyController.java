package com.InsuraFlow.PolicyService.controller;

import com.InsuraFlow.PolicyService.dto.PolicyRequestDto;
import com.InsuraFlow.PolicyService.dto.PolicyResponseDto;
import com.InsuraFlow.PolicyService.model.Policy;
import com.InsuraFlow.PolicyService.service.PolicyService;
import com.InsuraFlow.QuatoService.dto.QuoteRequestDto;
import com.InsuraFlow.QuatoService.model.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/policies")
@RestController
public class PolicyController {

    private final PolicyService policyService;

    public PolicyController(PolicyService policyService) {
        this.policyService = policyService;
    }

    @PostMapping
    public ResponseEntity<Policy> createPolicy(@RequestBody PolicyRequestDto dto) {
        Policy savedPolicy = policyService.createPolicy(dto);
        return ResponseEntity.ok(savedPolicy);
    }
    @GetMapping
    public ResponseEntity<List<Policy>> getAllPolicies() {
        System.out.println("Controller'a istek geldi!");
        List<Policy> policy = policyService.getAllPolicies();
        return ResponseEntity.ok(policy);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PolicyResponseDto> getPolicy(@PathVariable Long id) {
        return ResponseEntity.ok(policyService.getPolicyById(id));
    }
}