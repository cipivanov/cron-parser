package com.cron.parser.interpreter.impl;

import com.cron.parser.interpreter.AbstractInterpreter;
import com.cron.parser.model.CronField;

import java.util.ArrayList;
import java.util.List;

public class StarInterpreter extends AbstractInterpreter {

    public StarInterpreter(CronField cronField) {
        super(cronField);
    }

    //TODO: Create another abstract interpreter factory for field types to avoid duplication at this level

    @Override
    public void interpret() {
        List<String> result = new ArrayList<>();
        for (int i = cronField.getType().getRange().getMinimum(); i <= cronField.getType().getRange().getMaximum(); i++) {
            result.add(String.valueOf(i));
        }
        System.out.println(result);
    }
}