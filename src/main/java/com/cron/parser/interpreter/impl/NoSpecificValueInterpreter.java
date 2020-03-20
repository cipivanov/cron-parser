package com.cron.parser.interpreter.impl;

import com.cron.parser.interpreter.AbstractInterpreter;
import com.cron.parser.model.CronField;

import java.util.Collections;
import java.util.List;

public class NoSpecificValueInterpreter extends AbstractInterpreter {

    public NoSpecificValueInterpreter(CronField cronField) {
        super(cronField);
    }

    @Override
    public List<String> interpret() {
        return Collections.singletonList("<no specific value>");
    }
}