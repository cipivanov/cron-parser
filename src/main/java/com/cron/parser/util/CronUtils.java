package com.cron.parser.util;

import com.cron.parser.model.CronField;

public class CronUtils {

    public static final String LIST_TOKEN = ",";
    public static final String RANGE_TOKEN = "-";
    public static final String ALL_VALUES_TOKEN = "*";
    public static final String ALL_VALUES_WITH_INTERVAL_TOKEN = "*/";
    public static final String ALL_VALUES_WITH_INTERVAL_STARTING_TOKEN = "/";

    private CronUtils() {
    }

    public static boolean isListType(final CronField field) {
        return field.getValue().contains(LIST_TOKEN);
    }

    public static boolean isRangeType(final CronField field) {
        return field.getValue().contains(RANGE_TOKEN);
    }

    public static boolean isAllValuesType(final CronField field) {
        return field.getValue().contains(ALL_VALUES_TOKEN);
    }

    public static boolean isStarSlashType(final CronField field) {
        return field.getValue().contains(ALL_VALUES_WITH_INTERVAL_TOKEN);
    }

    public static boolean isSlashType(final CronField field) {
        return field.getValue().contains(ALL_VALUES_WITH_INTERVAL_STARTING_TOKEN);
    }
}