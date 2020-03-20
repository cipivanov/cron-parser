package com.cron.parser.interpreter.impl;

import com.cron.parser.interpreter.AbstractInterpreter;
import com.cron.parser.model.CronField;

import java.util.Arrays;

public class ListInterpreter extends AbstractInterpreter {

    public ListInterpreter(CronField cronField) {
        super(cronField);
    }

    @Override
    public void interpret() {
        System.out.println(Arrays.asList(cronField.getValue().split(",")));
    }
}