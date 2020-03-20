package com.cron.parser.util;

import com.cron.parser.model.FieldType;

import java.util.List;
import java.util.Map;

public class CronFormatter {

    private static final String OUTPUT_ROW_FORMAT = "%-13s %s\n";
    private static final String COMMAND_OUTPUT_ALIAS = "command";

    private CronFormatter() {
    }

    /**
     * Formats the interpretation result and the command into a specific format
     * <b>Format template:</b>
     * minute        <space separated execution times>
     * hour          <space separated execution times>
     * day of month  <space separated execution times>
     * month         <space separated execution times>
     * day of week   <space separated execution times>
     * command       <command>
     *
     * @param result  Cron expression interpretation result
     * @param command Cron expression afferent command
     * @return formatted String
     */
    public static String formatInterpretationResult(Map<FieldType, List<String>> result, String command) {
        StringBuffer formattedInterpretationResult = new StringBuffer();
        result.forEach((fieldType, value) -> formattedInterpretationResult
                .append(String.format(OUTPUT_ROW_FORMAT, fieldType.getAlias(), String.join(" ", value))));

        String formattedCommand = String.format(OUTPUT_ROW_FORMAT, COMMAND_OUTPUT_ALIAS, command);
        formattedInterpretationResult.append(formattedCommand);

        return formattedInterpretationResult.toString();
    }
}
