package com.cron.parser.interpreter.impl;

import com.cron.parser.interpreter.AbstractInterpreter;
import com.cron.parser.model.CronField;

import java.util.Arrays;
import java.util.List;

import static com.cron.parser.util.CronUtils.LIST_TOKEN;

public class ListInterpreter extends AbstractInterpreter {

    public ListInterpreter(CronField cronField) {
        super(cronField);
    }

    @Override
    public List<String> interpret() {
        return Arrays.asList(cronField.getValue().split(LIST_TOKEN));
    }
}