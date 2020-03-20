package com.cron.parser.interpreter.impl;

import com.cron.parser.interpreter.AbstractInterpreter;
import com.cron.parser.model.CronField;

import java.util.ArrayList;
import java.util.List;

public class SlashInterpreter extends AbstractInterpreter {

    public SlashInterpreter(CronField cronField) {
        super(cronField);
    }

    @Override
    public List<String> interpret() {
        List<String> result = new ArrayList<>();
        Integer step = Integer.valueOf(cronField.getValue().replace("*/", ""));
        for (int i = cronField.getType().getRange().getMinimum(); i <= cronField.getType().getRange().getMaximum(); i = i + step) {
            result.add(String.valueOf(i));
        }
        return result;
    }
}