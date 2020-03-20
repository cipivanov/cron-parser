package com.cron.parser;

import com.cron.parser.interpreter.impl.ListInterpreter;
import com.cron.parser.model.CronField;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.cron.parser.model.FieldType.MINUTE;

public class CronParserTest {

    @Test
    public void shouldInterpretMinuteList() {
        CronField cronField = new CronField(MINUTE, "0,15,30,45");

        ListInterpreter listInterpreter = new ListInterpreter(cronField);
        List<String> expectedResult = Arrays.asList("0", "15", "30", "45");
        assert listInterpreter.interpret().equals(expectedResult);
    }

    //TODO: Write test for all combinations of field position and type
    //TODO: Write test for factory class
    //TODO: Write test for output string of the parser itself
}