package com.zeotap.RuleEngine.model;

public class Node {
    private String type; // "operator" or "operand"
    private String value; // e.g., "AND", "OR", or condition string
    private Node left; // Left child
    private Node right; // Right child

    // Constructor
    public Node(String type, String value) {
        this.type = type;
        this.value = value;
    }

    // Getters and setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
