package com.cron.parser.interpreter;

import com.cron.parser.model.CronField;

/**
 * Represent the basic unit of interpretation. Any new type interpreter should extend this class
 */
public abstract class AbstractInterpreter implements Interpreter {

    protected CronField cronField;

    public AbstractInterpreter(CronField cronField) {
        this.cronField = cronField;
    }
}