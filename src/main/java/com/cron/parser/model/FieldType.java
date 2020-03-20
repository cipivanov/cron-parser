package com.cron.parser.model;

import org.apache.commons.lang3.Range;

public enum FieldType {

    MINUTE(Range.between(0, 59)),
    HOUR(Range.between(0, 23)),
    DAY_OF_THE_MONTH(Range.between(1, 31)),
    MONTH_OF_THE_YEAR(Range.between(1, 12)),
    DAY_OF_THE_WEEK(Range.between(1, 7));

    public Range<Integer> range;

    FieldType(Range<Integer> range) {
        this.range = range;
    }

    public Range<Integer> getRange() {
        return range;
    }
}