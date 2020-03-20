package com.cron.parser.interpreter.impl;

import com.cron.parser.interpreter.AbstractInterpreter;
import com.cron.parser.model.CronField;

import java.util.ArrayList;
import java.util.List;

import static com.cron.parser.util.CronUtils.RANGE_TOKEN;
import static com.cron.parser.util.CronUtils.SLASH_TOKEN;

public class RangeSlashInterpreter extends AbstractInterpreter {

    public RangeSlashInterpreter(CronField cronField) {
        super(cronField);
    }

    @Override
    public List<String> interpret() {
        List<String> executionTimes = new ArrayList<>();
        Integer start = getRangeStart();
        Integer end = getRangeEnd();
        Integer step = getStep();
        for (int i = start; i <= end; i += step) {
            executionTimes.add(String.valueOf(i));
        }
        return executionTimes;
    }

    private Integer getStep() {
        return Integer.valueOf(cronField.getValue().split(SLASH_TOKEN)[1]);
    }

    private Integer getRangeStart() {
        return Integer.valueOf(cronField.getValue()
                .split(SLASH_TOKEN)[0]
                .split(RANGE_TOKEN)[0]);
    }

    private Integer getRangeEnd() {
        return Integer.valueOf(cronField.getValue()
                .split(SLASH_TOKEN)[0]
                .split(RANGE_TOKEN)[1]);
    }
}