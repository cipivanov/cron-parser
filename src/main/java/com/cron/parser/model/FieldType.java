package com.cron.parser.model;

import com.cron.parser.util.Range;

/**
 * FieldType enumeration. Provides information pertaining to the particular filed valid range, output alias and
 * the expected position in the Cron expression (position variable).
 *
 * If a field is not defined here it cannot be interpreted.
 */
public enum FieldType {

    MINUTE(Range.between(0, 59), "minute", 0),
    HOUR(Range.between(0, 23), "hour", 1),
    DAY_OF_THE_MONTH(Range.between(1, 31), "day of month", 2),
    MONTH_OF_THE_YEAR(Range.between(1, 12), "month", 3),
    DAY_OF_THE_WEEK(Range.between(1, 7), "day of week", 4);

    public String alias;
    private Integer position;
    public Range<Integer> range;

    FieldType(Range<Integer> range, String alias, Integer position) {
        this.range = range;
        this.alias = alias;
        this.position = position;
    }

    public Range<Integer> getRange() {
        return range;
    }

    public String getAlias() {
        return alias;
    }

    public Integer getPosition() {
        return position;
    }
}