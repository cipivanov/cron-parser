package com.cron.parser.interpreter.impl;

import com.cron.parser.interpreter.AbstractInterpreter;
import com.cron.parser.model.CronField;

import java.util.ArrayList;
import java.util.List;

import static com.cron.parser.util.CronUtils.SLASH_TOKEN;

public class SlashInterpreter extends AbstractInterpreter {

    public SlashInterpreter(CronField cronField) {
        super(cronField);
    }

    @Override
    public List<String> interpret() {
        List<String> executionTimes = new ArrayList<>();
        Integer start = getMinimum();
        Integer end = getMaximum();
        Integer step = getStep();
        for (int i = start; i <= end; i += step) {
            executionTimes.add(String.valueOf(i));
        }
        return executionTimes;
    }

    private Integer getMinimum() {
        return Integer.valueOf(cronField.getValue().split(SLASH_TOKEN)[0]);
    }

    private Integer getMaximum() {
        return cronField.getType().getRange().getMaximum();
    }

    private Integer getStep() {
        return Integer.valueOf(cronField.getValue().split(SLASH_TOKEN)[1]);
    }
}