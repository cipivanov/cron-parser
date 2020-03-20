package com.cron.parser;

import com.cron.parser.impl.CronParser;
import org.junit.Test;

public class CronParserTest {

    Parser parser = new CronParser();

    @Test
    public void shouldSupplyValidFormatInterpretationFirst() {
        String expectedOutput =
                "minute        0 15 30 45\n" +
                        "hour          0\n" +
                        "day of month  1 15\n" +
                        "month         1 2 3 4 5 6 7 8 9 10 11 12\n" +
                        "day of week   1 2 3 4 5\n" +
                        "command       /usr/bin/find\n";

        String actualOutput = parser.parse("*/15 0 1,15 * 1-5 /usr/bin/find");

        assert expectedOutput.equals(actualOutput);
    }

    @Test
    public void shouldSupplyValidFormatInterpretationSecond() {
        String expectedOutput =
                "minute        0\n" +
                        "hour          0\n" +
                        "day of month  1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31\n" +
                        "month         1 2 3 4 5 6 7 8 9 10 11 12\n" +
                        "day of week   1 2 3 4 5 6 7\n" +
                        "command       find $HOME -name core 2>/dev/null | xargs rm -f\n";

        String actualOutput = parser.parse("0 0 * * * find $HOME -name core 2>/dev/null | xargs rm -f");

        assert expectedOutput.equals(actualOutput);
    }

    @Test
    public void shouldSupplyValidFormatInterpretationThird() {
        String expectedOutput =
                "minute        0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59\n" +
                        "hour          0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23\n" +
                        "day of month  1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31\n" +
                        "month         1 2 3\n" +
                        "day of week   1 2 3 4 5 6 7\n" +
                        "command       another command\n";

        String actualOutput = parser.parse("* * * 1,2,3 * another command");

        assert expectedOutput.equals(actualOutput);
    }

    @Test
    public void shouldSupplyValidFormatInterpretationFourth() {
        String expectedOutput =
                "minute        0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59\n" +
                        "hour          0 1 2 3 4 5 6 7 8 9 10 11\n" +
                        "day of month  1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31\n" +
                        "month         1 2 3 4 5 6 7 8 9 10 11 12\n" +
                        "day of week   1 2 3 4 5 6 7\n" +
                        "command       <no command>\n";

        String actualOutput = parser.parse("* 0-11 * * *");

        assert expectedOutput.equals(actualOutput);
    }

    @Test
    public void shouldSupplyValidFormatInterpretationFifth() {
        String expectedOutput =
                "minute        0\n" +
                        "hour          0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23\n" +
                        "day of month  14\n" +
                        "month         1 2 3 4 5 6 7 8 9 10 11 12\n" +
                        "day of week   <no specific value>\n" +
                        "command       <no command>\n";

        String actualOutput = parser.parse("0 * 14 * ?");

        assert expectedOutput.equals(actualOutput);
    }
}