package com.cron.parser.interpreter.impl;

import com.cron.parser.interpreter.AbstractInterpreter;
import com.cron.parser.model.CronField;

import java.util.ArrayList;
import java.util.List;

import static com.cron.parser.util.CronUtils.NO_SPECIFIC_VALUE_TOKEN;
import static com.cron.parser.util.CronUtils.STAR_SLASH_TOKEN;

public class StarSlashInterpreter extends AbstractInterpreter {

    public StarSlashInterpreter(CronField cronField) {
        super(cronField);
    }

    @Override
    public List<String> interpret() {
        List<String> executionTimes = new ArrayList<>();
        for (int i = getMinimum(); i <= getMaximum(); i += getStep()) {
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

    private Integer getStep() {
        return Integer.valueOf(cronField.getValue().replace(STAR_SLASH_TOKEN, ""));
    }
}