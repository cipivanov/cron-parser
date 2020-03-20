package com.cron.parser.impl;

import com.cron.parser.interpreter.InterpreterFactory;
import com.cron.parser.model.CronField;
import com.cron.parser.Parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.cron.parser.model.FieldType.*;

public class CronParser implements Parser {

    public void parse(String expression) {
        List<CronField> cronExpression = getListOfCronFields(expression);

        //TODO: Adjust formatting to meet acceptance criteria
        interpret(cronExpression);
    }

    private void interpret(List<CronField> cronExpression) {
        cronExpression.forEach(cronField -> InterpreterFactory.getInterpreter(cronField).interpret());
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
                new CronField(DAY_OF_THE_WEEK, fields.get(4))
        );
    }
}