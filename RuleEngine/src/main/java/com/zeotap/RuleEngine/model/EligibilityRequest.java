package com.zeotap.RuleEngine.model;

public class EligibilityRequest {
    private String name;
    private int age;
    private String department;
    private double income;
    private double spending;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getSpending() {
        return spending;
    }

    public void setSpending(double spending) {
        this.spending = spending;
    }
}
