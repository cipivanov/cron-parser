package com.cron.parser.interpreter.impl;

import com.cron.parser.interpreter.AbstractInterpreter;
import com.cron.parser.model.CronField;

import java.util.ArrayList;
import java.util.List;

public class StarInterpreter extends AbstractInterpreter {

    public StarInterpreter(CronField cronField) {
        super(cronField);
    }

    @Override
    public List<String> interpret() {
        List<String> executionTimes = new ArrayList<>();
        Integer start = getMinimum();
        Integer end = getMaximum();
        for (int i = start; i <= end; i++) {
            executionTimes.add(String.valueOf(i));
        }
        return executionTimes;
    }

    private Integer getMinimum() {
        return cronField.getType().getRange().getMinimum();
    }

    private Integer getMaximum() {
        return cronField.getType().getRange().getMaximum();
    }
}