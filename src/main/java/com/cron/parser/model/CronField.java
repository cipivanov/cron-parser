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

    public String getValue() {
        return value;
    }
}