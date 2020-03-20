package com.cron.parser.interpreter;

import com.cron.parser.interpreter.impl.*;
import com.cron.parser.model.CronField;

public abstract class InterpreterFactory {

    public static AbstractInterpreter getInterpreter(CronField cronField) {

        if (cronField.getValue().contains("*/")) {
            return new SlashInterpreter(cronField);
        } else if (cronField.getValue().contains("*")) {
            return new StarInterpreter(cronField);
        } else if (cronField.getValue().contains("-")) {
            return new RangeInterpreter(cronField);
        } else if (cronField.getValue().contains(",")) {
            return new ListInterpreter(cronField);
        } else if (cronField.getValue().contains("/")) {
            return new CommandInterpreter(cronField);
        } else {
            return new SingleValueInterpreter(cronField);
        }
    }
}