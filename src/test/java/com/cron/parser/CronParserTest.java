package com.cron.parser;

import com.cron.parser.impl.CronParser;
import org.junit.Test;

public class CronParserTest {

    private CronParser cronParser = new CronParser();

    @Test
    public void shouldEvaluateCronExpressionAndPrintResult() {
        cronParser.parse("*/15 0 1,15 * 1-5 /usr/bin/find");
        System.out.println("-------------------------------------------");
        cronParser.parse("0 11 11 11 11 /usr/bin/find");
        System.out.println("-------------------------------------------");
        //TODO: Remains to investigate if the case is a valid one 1/5
        cronParser.parse("0 0 12 1/5 * /usr/bin/find");
        System.out.println("-------------------------------------------");
        cronParser.parse("0 0-5 14 * * /usr/bin/find");
        System.out.println("-------------------------------------------");
    }
}