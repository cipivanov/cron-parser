package com.cron.parser.util;

import com.cron.parser.model.CronField;

public class CronUtils {

    public static final String LIST_TOKEN = ",";
    public static final String STAR_TOKEN = "*";
    public static final String RANGE_TOKEN = "-";
    public static final String SLASH_TOKEN = "/";
    public static final String STAR_SLASH_TOKEN = "*/";
    public static final String NO_SPECIFIC_VALUE_TOKEN = "?";

    private CronUtils() {
    }

    public static boolean isListType(final CronField field) {
        return field.getValue().contains(LIST_TOKEN);
    }

    public static boolean isRangeType(final CronField field) {
        return field.getValue().contains(RANGE_TOKEN);
    }

    public static boolean isAllValuesType(final CronField field) {
        return field.getValue().contains(STAR_TOKEN);
    }

    public static boolean isStarSlashType(final CronField field) {
        return field.getValue().contains(STAR_SLASH_TOKEN);
    }

    public static boolean isSlashType(final CronField field) {
        return field.getValue().contains(SLASH_TOKEN);
    }

    public static boolean isRangeSlashInterpreter(final CronField field) {
        return field.getValue().contains(RANGE_TOKEN) && field.getValue().contains(SLASH_TOKEN);
    }

    public static boolean isNoSpecificValueType(final CronField field) {
        return field.getValue().contains(NO_SPECIFIC_VALUE_TOKEN);
    }
}