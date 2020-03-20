package com.cron.parser;

import com.cron.parser.impl.CronParser;
import org.junit.Test;

public class CronParserTest {

    private CronParser cronParser = new CronParser();

    @Test
    public void shouldEvaluateCronExpressionAndPrintResult() {
        // only cron expression for now, no command
        cronParser.parse("*/15 0 1,15 * 1-5");
    }
}