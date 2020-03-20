package com.cron.parser.impl;

import com.cron.parser.Parser;
import com.cron.parser.interpreter.InterpreterFactory;
import com.cron.parser.model.CronField;
import com.cron.parser.model.FieldType;
import com.cron.parser.util.StringUtils;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.cron.parser.model.FieldType.*;


public class CronParser implements Parser {

    public void parse(String expression) {
        interpret(getListOfCronFields(expression));
    }

    private void interpret(List<CronField> cronExpression) {
        Map<FieldType, List<String>> result = new LinkedHashMap<>();
        cronExpression.forEach(cronField ->
                result.put(cronField.getType(), InterpreterFactory.getInterpreter(cronField).interpret()));

        System.out.println(StringUtils.formatCronResult(result));
    }

    private List<CronField> getListOfCronFields(String cronExpression) {
        List<String> fields = Stream.of(cronExpression)
                .map(expression -> expression.split("\\s+"))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());

        //TODo: A better/safer way to create the CronFields
        return Arrays.asList(
                new CronField(MINUTE, fields.get(0)),
                new CronField(HOUR, fields.get(1)),
                new CronField(DAY_OF_THE_MONTH, fields.get(2)),
                new CronField(MONTH_OF_THE_YEAR, fields.get(3)),
                new CronField(DAY_OF_THE_WEEK, fields.get(4)),
                new CronField(COMMAND, fields.get(5))
        );
    }
}