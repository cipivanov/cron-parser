package com.cron.parser.interpreter.impl;

import com.cron.parser.interpreter.AbstractInterpreter;
import com.cron.parser.interpreter.InterpreterFactory;
import com.cron.parser.model.CronField;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.cron.parser.util.CronUtils.LIST_TOKEN;

public class ListInterpreter extends AbstractInterpreter {

    public ListInterpreter(CronField cronField) {
        super(cronField);
    }

    @Override
    public List<String> interpret() {
        List<String> executionTimes = new ArrayList<>();
        for (String element : cronField.getValue().split(LIST_TOKEN)) {
            // tacky solution to the list with multiple types "issue" :(
             executionTimes.addAll(
                     InterpreterFactory.getInterpreter(new CronField(cronField.getType(), element)).interpret());
        }
        return executionTimes;
    }
}