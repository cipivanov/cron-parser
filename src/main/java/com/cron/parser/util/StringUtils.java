package com.cron.parser.util;


import com.cron.parser.model.FieldType;

import java.util.List;
import java.util.Map;

public class StringUtils {

    private StringUtils() {
    }

    public static String formatCronResult(Map<FieldType, List<String>> result) {
        StringBuffer formattedResult = new StringBuffer();
        String row = "%-14s %s\n";

        result.forEach(
                (fieldType, values) ->
                        formattedResult.append(
                                String.format(row, fieldType.getAlias(), String.join(" ", values))));

        return formattedResult.toString();
    }
}