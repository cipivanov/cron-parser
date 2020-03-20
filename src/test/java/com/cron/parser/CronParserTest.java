package com.cron.parser;

import com.cron.parser.impl.CronParser;
import org.junit.Test;

public class CronParserTest {

    private CronParser cronParser = new CronParser();

    @Test
    public void shouldEvaluateCronExpressionAndPrintResult() {
        cronParser.parse("*/15 0 1,15 * 1-5");
    }
}