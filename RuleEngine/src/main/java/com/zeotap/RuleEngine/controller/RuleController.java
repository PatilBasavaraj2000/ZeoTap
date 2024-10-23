package com.zeotap.RuleEngine.controller;

import com.sun.net.httpserver.Authenticator;
import com.zeotap.RuleEngine.model.EligibilityRequest;
import com.zeotap.RuleEngine.model.Rule;
import com.zeotap.RuleEngine.service.RuleEngineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/RuleEngine")
public class RuleController {

    private final RuleEngineService ruleEngineService;

    public RuleController(RuleEngineService ruleEngineService) {
        this.ruleEngineService = ruleEngineService;

    }

    @PostMapping("/check")
    public ResponseEntity<String> checkEligibility(@RequestBody EligibilityRequest request) {
        boolean isEligible = ruleEngineService.evaluateEligibility(request);
        return ResponseEntity.ok(isEligible ? "User is eligible." : "User is not eligible.");
    }

    @PostMapping
    public ResponseEntity<Rule> createRule(@RequestBody Rule rule) {
        Rule createdRule = ruleEngineService.createRule(String.valueOf(rule));

        return ResponseEntity.status(201).body(createdRule);
    }

    @GetMapping
    public ResponseEntity<List<Rule>> getAllRules() {
        List<Rule> rules = ruleEngineService.getAllRules();
        return ResponseEntity.ok(rules);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rule> getRuleById(@PathVariable Long id) {
        Rule rule = ruleEngineService.getRuleById(id);
        return rule != null ? ResponseEntity.ok(rule) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rule> updateRule(@PathVariable Long id, @RequestBody Rule rule) {
        Rule updatedRule = ruleEngineService.updateRule(id, rule);
        return updatedRule != null ? ResponseEntity.ok(updatedRule) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRule(@PathVariable Long id) {
        boolean isDeleted = ruleEngineService.deleteRule(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
