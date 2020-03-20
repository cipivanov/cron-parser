package com.cron.parser.impl;

import com.cron.parser.Parser;
import com.cron.parser.interpreter.InterpreterFactory;
import com.cron.parser.model.CronField;
import com.cron.parser.model.FieldType;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.cron.parser.util.RegexUtils.getFirstMatch;
import static com.cron.parser.util.RegexUtils.getMatchGroup;


public class CronParser implements Parser {

    private static final String OUTPUT_ROW_FORMAT = "%-14s %s\n";

    private static final String COMMAND_OUTPUT_ALIAS = "command";
    private static final String COMMAND_PLACEHOLDER = "<no command>";

    private static final String COMMAND_REGEX = "(?:\\S{1,}\\s){5}(.*)";
    private static final String CRON_EXPRESSION_REGEX = "(?:\\S{1,}\\s){4}(?:\\S{1,})";

    public String parse(String expression) {
        String command = getCronCommand(expression);
        List<CronField> cronFields = getCronFields(expression);
        Map<FieldType, List<String>> interpretationResult = interpret(cronFields);

        return formatInterpretationResult(interpretationResult, command);
    }

    public Map<FieldType, List<String>> interpret(List<CronField> cronExpression) {
        Map<FieldType, List<String>> result = new LinkedHashMap<>();
        cronExpression.forEach(cronField ->
                result.put(cronField.getType(), InterpreterFactory.getInterpreter(cronField).interpret()));

        return result;
    }

    private List<CronField> getCronFields(String expression) {
        String cronExpression = getFirstMatch(expression, CRON_EXPRESSION_REGEX)
                .orElseThrow(() -> new RuntimeException("Not a valid Cron expression"));

        List<String> cronFields = Stream.of(cronExpression)
                .map(fields -> fields.split("\\s+"))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());

        return Stream.of(FieldType.values())
                .map(fieldType -> new CronField(fieldType, cronFields.get(fieldType.getPosition())))
                .collect(Collectors.toList());
    }

    private String getCronCommand(String cronExpression) {
        return getMatchGroup(cronExpression, COMMAND_REGEX, 1).orElse(COMMAND_PLACEHOLDER);
    }


    private String formatInterpretationResult(Map<FieldType, List<String>> result, String command) {
        StringBuffer formattedInterpretationResult = new StringBuffer();
        result.forEach((fieldType, value) -> formattedInterpretationResult
                .append(String.format(OUTPUT_ROW_FORMAT, fieldType.getAlias(), String.join(" ", value))));

        String formattedCommand = String.format(OUTPUT_ROW_FORMAT, COMMAND_OUTPUT_ALIAS, command);
        formattedInterpretationResult.append(formattedCommand);

        return formattedInterpretationResult.toString();
    }
}