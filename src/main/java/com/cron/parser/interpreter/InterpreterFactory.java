package com.cron.parser.interpreter;

import com.cron.parser.interpreter.impl.*;
import com.cron.parser.model.CronField;

import static com.cron.parser.util.CronUtils.*;

public abstract class InterpreterFactory {

    public static AbstractInterpreter getInterpreter(CronField cronField) {

        if (isRangeSlashInterpreter(cronField)) {
            return new RangeSlashInterpreter(cronField);
        } else if (isListType(cronField)) {
            return new ListInterpreter(cronField);
        } else if (isStarSlashType(cronField)) {
            return new StarSlashInterpreter(cronField);
        } else if (isAllValuesType(cronField)) {
            return new StarInterpreter(cronField);
        } else if (isRangeType(cronField)) {
            return new RangeInterpreter(cronField);
        } else if (isSlashType(cronField)) {
            return new SlashInterpreter(cronField);
        } else if (isNoSpecificValueType(cronField)) {
            return new NoSpecificValueInterpreter(cronField);
        } else {
            return new SingleValueInterpreter(cronField);
        }
    }
}