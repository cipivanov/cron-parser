package com.cron.parser.interpreter.impl;

import com.cron.parser.interpreter.AbstractInterpreter;
import com.cron.parser.model.CronField;

import java.util.Arrays;
import java.util.List;

public class RangeInterpreter extends AbstractInterpreter {

    public RangeInterpreter(CronField cronField) {
        super(cronField);
    }

    @Override
    public List<String> interpret() {
        return Arrays.asList(cronField.getValue().split("-"));
    }
}