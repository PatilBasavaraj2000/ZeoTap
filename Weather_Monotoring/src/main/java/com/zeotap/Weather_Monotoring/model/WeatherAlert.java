package com.zeotap.Weather_Monotoring.model;

public class WeatherAlert {
    private String alertType;  // Type of the weather alert (e.g., Storm, Flood)
    private String description; // Description of the alert
    private String severity;    // Severity level (e.g., Minor, Moderate, Severe)
    private String affectedArea; // Area affected by the alert
    private String timestamp;    // When the alert was issued

    // Constructor
    public WeatherAlert(String alertType, String description, String severity, String affectedArea, String timestamp) {
        this.alertType = alertType;
        this.description = description;
        this.severity = severity;
        this.affectedArea = affectedArea;
        this.timestamp = timestamp;
    }

    // Getters
    public String getAlertType() {
        return alertType;
    }

    public String getDescription() {
        return description;
    }

    public String getSeverity() {
        return severity;
    }

    public String getAffectedArea() {
        return affectedArea;
    }

    public String getTimestamp() {
        return timestamp;
    }

    // Setters
    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public void setAffectedArea(String affectedArea) {
        this.affectedArea = affectedArea;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "WeatherAlert{" +
                "alertType='" + alertType + '\'' +
                ", description='" + description + '\'' +
                ", severity='" + severity + '\'' +
                ", affectedArea='" + affectedArea + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }

    public String getMessage() {
        return "";
    }
}
