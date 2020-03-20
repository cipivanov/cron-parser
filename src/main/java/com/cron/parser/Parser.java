package com.cron.parser;

/**
 * Represents a Parser interface capable of parsing standard Cron expressions (five time fields + command)
 * The supported time fields are: MINUTE, HOUR, DAY OF MONTH, MONTH, DAY OF WEEK.
 */
public interface Parser {

    /**
     * Parses the Cron expression supplied and returns a pre-formatted String result
     * <b>Example valid input:</b> *\/15 0 1,15 * 1-5 /usr/bin/find
     * <b>Example valid output:</b>
     * minute        0 15 30 45
     * hour          0
     * day of month  1 15
     * month         1 2 3 4 5 6 7 8 9 10 11 12
     * day of week   1 2 3 4 5
     * command       /usr/bin/find
     *
     * @param expression valid standard Cron expression, 5 Cron fields + command
     * @return formatted String interpretation of the execution times for the expression
     */
    String parse(String expression);
}