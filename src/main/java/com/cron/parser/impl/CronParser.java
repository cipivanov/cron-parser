package com.cron.parser.impl;

import com.cron.interpreter.Interpreter;
import com.cron.parser.Parser;

public class CronParser implements Parser {

    @Override
    public void parse(String expression) {
        new Interpreter(expression).interpret();
    }
}