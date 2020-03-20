package com.cron.parser.model;

import org.apache.commons.lang3.Range;

public enum FieldType {

    MINUTE(Range.between(0, 59), "minute"),
    HOUR(Range.between(0, 23), "hour"),
    DAY_OF_THE_MONTH(Range.between(1, 31), "day of month"),
    MONTH_OF_THE_YEAR(Range.between(1, 12), "month"),
    DAY_OF_THE_WEEK(Range.between(1, 7), "day of week"),
    COMMAND("command");

    public String alias;
    public Range<Integer> range;

    FieldType(Range<Integer> range, String alias) {
        this.range = range;
        this.alias = alias;
    }

    FieldType(String alias) {
        this.alias = alias;
    }

    public Range<Integer> getRange() {
        return range;
    }

    public String getAlias() {
        return alias;
    }
}