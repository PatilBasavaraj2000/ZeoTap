package com.zeotap.RuleEngine.udf;


import java.util.Map;

public interface UserDefinedFunction {
    boolean evaluate(Map<String, Object> attributes);
}
