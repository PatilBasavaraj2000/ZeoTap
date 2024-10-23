package com.zeotap.RuleEngine.service;

import com.zeotap.RuleEngine.model.Rule;
import com.zeotap.RuleEngine.repository.RuleRepository;
import com.zeotap.RuleEngine.udf.UserDefinedFunction;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RuleService {

    private final RuleRepository ruleRepository;

    public RuleService(RuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    // Create a new rule
    public Rule createRule(Rule rule) {
        return ruleRepository.save(rule);
    }

    // Evaluate a rule against provided attributes
    public boolean evaluateRule(Rule rule, Map<String, Object> attributes, List<UserDefinedFunction> customFunctions) {
        boolean result = rule.evaluate(attributes); // Assuming Rule has an evaluate method

        // Check against custom user-defined functions
        for (UserDefinedFunction function : customFunctions) {
            if (function.evaluate(attributes)) {
                // Implement logic based on UDF results
                result = true; // Modify based on your specific logic
            }
        }

        return result; // Return final evaluation result
    }

    // Get all rules
    public List<Rule> getAllRules() {
        return ruleRepository.findAll();
    }

    // Get rule by ID
    public Rule getRuleById(Long id) {
        return ruleRepository.findById(id).orElse(null); // Return null if not found
    }

    // Update a rule
    public Rule updateRule(Long id, Rule updatedRule) {
        if (ruleRepository.existsById(id)) {
            updatedRule.setId(id); // Ensure the ID is set for the update
            return ruleRepository.save(updatedRule);
        }
        return null; // Return null if the rule was not found
    }

    // Delete a rule
    public boolean deleteRule(Long id) {
        if (ruleRepository.existsById(id)) {
            ruleRepository.deleteById(id);
            return true; // Successfully deleted
        }
        return false; // Rule not found
    }
}
