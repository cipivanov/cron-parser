package com.cron.parser.interpreter.impl;

import com.cron.parser.interpreter.AbstractInterpreter;
import com.cron.parser.model.CronField;

import java.util.Arrays;

public class RangeInterpreter extends AbstractInterpreter {

    public RangeInterpreter(CronField cronField) {
        super(cronField);
    }

    //TODO: Create another abstract interpreter factory for field types to avoid duplication at this level

    @Override
    public void interpret() {
        System.out.println(Arrays.asList(cronField.getValue().split("-")));
    }
}