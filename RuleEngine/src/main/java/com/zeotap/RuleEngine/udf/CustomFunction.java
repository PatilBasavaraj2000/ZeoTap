package com.zeotap.RuleEngine.udf;

import java.util.Map;

public class CustomFunction implements UserDefinedFunction {
    @Override
    public boolean evaluate(Map<String, Object> attributes) {
        // Implement custom logic, e.g., specific conditions
        return (int) attributes.get("age") > 30; // Example condition
    }
}
