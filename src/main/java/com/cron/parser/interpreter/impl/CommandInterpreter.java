package com.cron.parser.interpreter.impl;

import com.cron.parser.interpreter.AbstractInterpreter;
import com.cron.parser.model.CronField;

import java.util.Arrays;
import java.util.List;

public class CommandInterpreter extends AbstractInterpreter {

    public CommandInterpreter(CronField cronField) {
        super(cronField);
    }

    @Override
    public List<String> interpret() {
        return Arrays.asList(cronField.getValue());
    }
}