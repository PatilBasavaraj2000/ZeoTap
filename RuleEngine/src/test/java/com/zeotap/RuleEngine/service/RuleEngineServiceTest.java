package com.zeotap.RuleEngine.service;

import com.zeotap.RuleEngine.model.Node;
import com.zeotap.RuleEngine.model.Rule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RuleEngineServiceTest {

    @Autowired
    private RuleEngineService ruleEngineService;

    @Test
    public void testCreateRule() {
        String ruleString = "((age > 30 AND department = 'Sales'))";
        Rule ast = ruleEngineService.createRule(ruleString);

        assertNotNull(ast);
        assertEquals("operator", ast.getType());
        assertEquals("AND", ast.getValue());
        assertNotNull(ast.getLeft());
        assertEquals("operand", ast.getLeft().getType());
    }

    @Test
    public void testCombineRules() {
        List<String> rules = List.of(
                "((age > 30 AND department = 'Sales'))",
                "((age < 25 AND department = 'Marketing'))"
        );
        Node combinedAst = ruleEngineService.combineRules(rules);

        assertNotNull(combinedAst);
        assertEquals("operator", combinedAst.getType());
        assertEquals("AND", combinedAst.getValue());
        assertNotNull(combinedAst.getLeft());
        assertNotNull(combinedAst.getRight());
    }

    @Test
    public void testEvaluateRuleTrue() {
        String ruleString = "((age > 30 AND department = 'Sales'))";
        Rule ast = ruleEngineService.createRule(ruleString);

        Map<String, Object> data = new HashMap<>();
        data.put("age", 35);
        data.put("department", "Sales");

        boolean result = ruleEngineService.evaluateRule(ast, data);
        assertTrue(result);
    }

    @Test
    public void testEvaluateRuleFalse() {
        String ruleString = "((age > 30 AND department = 'Sales'))";
        Rule ast = ruleEngineService.createRule(ruleString);

        Map<String, Object> data = new HashMap<>();
        data.put("age", 25);
        data.put("department", "Sales");

        boolean result = ruleEngineService.evaluateRule(ast, data);
        assertFalse(result);
    }

    @Test
    public void testEvaluateCombinedRules() {
        List<String> rules = List.of(
                "((age > 30 AND department = 'Sales'))",
                "((salary > 50000 OR experience > 5))"
        );
        Node combinedAst = ruleEngineService.combineRules(rules);

        Map<String, Object> data = new HashMap<>();
        data.put("age", 35);
        data.put("department", "Sales");
        data.put("salary", 60000);
        data.put("experience", 2);

        boolean result = ruleEngineService.evaluateRule(combinedAst, data);
        assertTrue(result);
    }
}
