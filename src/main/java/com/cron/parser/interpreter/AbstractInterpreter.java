package com.cron.parser.interpreter;

import com.cron.parser.model.CronField;

public abstract class AbstractInterpreter implements Interpreter {

    protected CronField cronField;

    public AbstractInterpreter(CronField cronField) {
        this.cronField = cronField;
    }
}