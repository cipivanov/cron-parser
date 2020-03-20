package com.cron.parser.cli;

import com.cron.parser.impl.CronParser;

public class CommandLineInterface {

    public static void main(String[] args) {
        validateArguments(args);
        System.out.print(new CronParser().parse(args[0]));
    }

    private static void validateArguments(final String[] arguments) {
        if (arguments.length != 1) {
            throw new IllegalArgumentException("Invalid Cron expression format");
        }
    }
}