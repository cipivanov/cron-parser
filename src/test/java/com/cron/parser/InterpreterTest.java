package com.cron.parser;

import com.cron.parser.interpreter.impl.*;
import com.cron.parser.model.CronField;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.cron.parser.model.FieldType.*;

public class InterpreterTest {

    @Test
    public void shouldInterpretMinuteList() {
        List<String> expectedResult = Arrays.asList("1", "2", "3", "5", "20", "21", "22", "23", "24", "25",
                "30", "31", "32", "33", "34", "35", "59");

        CronField cronField = new CronField(MINUTE, "1,2,3,5,20-25,30-35,59");
        ListInterpreter listInterpreter = new ListInterpreter(cronField);

        assert listInterpreter.interpret().equals(expectedResult);
    }

    @Test
    public void shouldInterpretHourRange() {
        List<String> expectedResult = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");

        CronField cronField = new CronField(HOUR, "1-10");
        RangeInterpreter rangeInterpreter = new RangeInterpreter(cronField);

        assert rangeInterpreter.interpret().equals(expectedResult);
    }

    @Test
    public void shouldInterpretDayOfTheMonthSingleValue() {
        List<String> expectedResult = Collections.singletonList("11");

        CronField cronField = new CronField(DAY_OF_THE_MONTH, "11");
        SingleValueInterpreter singleValueInterpreter = new SingleValueInterpreter(cronField);

        assert singleValueInterpreter.interpret().equals(expectedResult);
    }

    @Test
    public void shouldInterpretMonthOfTheYearSlashValue() {
        List<String> expectedResult = Arrays.asList("1", "6", "11");

        CronField cronField = new CronField(MONTH_OF_THE_YEAR, "1/5");
        SlashInterpreter slashInterpreter = new SlashInterpreter(cronField);

        assert slashInterpreter.interpret().equals(expectedResult);
    }

    @Test
    public void shouldInterpretDayOfTheWeekStarValue() {
        List<String> expectedResult = Arrays.asList("1", "2", "3", "4", "5", "6", "7");

        CronField cronField = new CronField(DAY_OF_THE_WEEK, "*");
        StarInterpreter starInterpreter = new StarInterpreter(cronField);

        assert starInterpreter.interpret().equals(expectedResult);
    }

    @Test
    public void shouldInterpretDayOfTheWeekStarSlashValue() {
        List<String> expectedResult = Arrays.asList("1", "3", "5", "7");

        CronField cronField = new CronField(DAY_OF_THE_WEEK, "*/2");
        StarSlashInterpreter starSlashInterpreter = new StarSlashInterpreter(cronField);

        assert starSlashInterpreter.interpret().equals(expectedResult);
    }

    @Test
    public void shouldInterpretDayOfTheWeekRangeSlashValue() {
        List<String> expectedResult = Arrays.asList("1", "4", "7", "10", "13", "16", "19", "22", "25", "28");

        CronField cronField = new CronField(DAY_OF_THE_WEEK, "1-30/3");
        RangeSlashInterpreter rangeSlashInterpreter = new RangeSlashInterpreter(cronField);

        assert rangeSlashInterpreter.interpret().equals(expectedResult);
    }
}
