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
        List<String> expectedResult = Arrays.asList("0", "15", "30", "45");

        CronField cronField = new CronField(MINUTE, "0,15,30,45");
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
    public void shouldInterpretSingleValue() {
        List<String> expectedResult = Collections.singletonList("11");

        CronField cronField = new CronField(DAY_OF_THE_MONTH, "11");
        SingleValueInterpreter singleValueInterpreter = new SingleValueInterpreter(cronField);

        assert singleValueInterpreter.interpret().equals(expectedResult);
    }

    @Test
    public void shouldInterpretSlashValue() {
        List<String> expectedResult = Arrays.asList("1", "6", "11");

        CronField cronField = new CronField(MONTH_OF_THE_YEAR, "1/5");
        SlashInterpreter slashInterpreter = new SlashInterpreter(cronField);

        assert slashInterpreter.interpret().equals(expectedResult);
    }

    @Test
    public void shouldInterpretStarValue() {
        List<String> expectedResult = Arrays.asList("1", "2", "3", "4", "5", "6", "7");

        CronField cronField = new CronField(DAY_OF_THE_WEEK, "*");
        StarInterpreter starInterpreter = new StarInterpreter(cronField);

        assert starInterpreter.interpret().equals(expectedResult);
    }

    @Test
    public void shouldInterpretStarSlashValue() {
        List<String> expectedResult = Arrays.asList("1", "3", "5", "7");

        CronField cronField = new CronField(DAY_OF_THE_WEEK, "*/2");
        StarSlashInterpreter starSlashInterpreter = new StarSlashInterpreter(cronField);

        assert starSlashInterpreter.interpret().equals(expectedResult);
    }

    @Test
    public void shouldInterpretRangeSlashValue() {
        List<String> expectedResult = Arrays.asList("1", "4", "7", "10", "13", "16", "19", "22", "25", "28");

        CronField cronField = new CronField(DAY_OF_THE_WEEK, "1-30/3");
        RangeSlashInterpreter rangeSlashInterpreter = new RangeSlashInterpreter(cronField);

        assert rangeSlashInterpreter.interpret().equals(expectedResult);
    }
}
