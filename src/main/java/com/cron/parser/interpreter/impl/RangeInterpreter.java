package com.cron.parser.interpreter.impl;

import com.cron.parser.interpreter.AbstractInterpreter;
import com.cron.parser.model.CronField;

import java.util.Arrays;
import java.util.List;

import static com.cron.parser.util.CronUtils.RANGE_TOKEN;

public class RangeInterpreter extends AbstractInterpreter {

    public RangeInterpreter(CronField cronField) {
        super(cronField);
    }

    @Override
    public List<String> interpret() {
        return Arrays.asList(cronField.getValue().split(RANGE_TOKEN));
    }
}