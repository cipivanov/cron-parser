package com.cron.parser.model;

public class CronField {

    private FieldType type;
    private String value;

    public CronField(FieldType type, String value) {
        this.type = type;
        this.value = value;
    }

    public FieldType getType() {
        return type;
    }

    public void setType(FieldType type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}