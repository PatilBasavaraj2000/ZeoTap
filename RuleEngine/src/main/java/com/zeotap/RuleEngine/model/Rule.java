package com.zeotap.RuleEngine.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Map;


@Entity
public class Rule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    private String name;
    private String condition; // Serialized AST representation

    public boolean evaluate(Map<String, Object> attributes) {
        return false;
    }

    public String getType() {
        return "";
    }

    public String getValue() {
        return "";
    }

    public Rule getLeft() {
        return null;
    }

    // Getters and Setters
}
