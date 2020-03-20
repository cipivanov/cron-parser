package com.cron.parser.interpreter;

import com.cron.parser.model.CronField;

public abstract class AbstractInterpreter {

    protected CronField cronField;

    public abstract void interpret();

    public AbstractInterpreter(CronField cronField) {
        this.cronField = cronField;
    }
}