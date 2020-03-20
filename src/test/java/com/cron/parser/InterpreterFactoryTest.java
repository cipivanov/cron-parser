package com.cron.parser;

import com.cron.parser.interpreter.InterpreterFactory;
import com.cron.parser.interpreter.impl.*;
import com.cron.parser.model.CronField;
import com.cron.parser.model.FieldType;
import org.junit.Test;

public class InterpreterFactoryTest {

    @Test
    public void shouldSupplyListInterpreter() {
        CronField cronField = new CronField(FieldType.HOUR, "1,3");

        assert InterpreterFactory.getInterpreter(cronField).getClass().equals(ListInterpreter.class);
    }

    @Test
    public void shouldSupplyRangeInterpreter() {
        CronField cronField = new CronField(FieldType.HOUR, "1-3");

        assert InterpreterFactory.getInterpreter(cronField).getClass().equals(RangeInterpreter.class);
    }

    @Test
    public void shouldSupplyRangeSlashInterpreter() {
        CronField cronField = new CronField(FieldType.HOUR, "1-12/3");

        assert InterpreterFactory.getInterpreter(cronField).getClass().equals(RangeSlashInterpreter.class);
    }

    @Test
    public void shouldSupplySingleValueInterpreter() {
        CronField cronField = new CronField(FieldType.HOUR, "1");

        assert InterpreterFactory.getInterpreter(cronField).getClass().equals(SingleValueInterpreter.class);
    }

    @Test
    public void shouldSupplySlashInterpreter() {
        CronField cronField = new CronField(FieldType.HOUR, "1/3");

        assert InterpreterFactory.getInterpreter(cronField).getClass().equals(SlashInterpreter.class);
    }

    @Test
    public void shouldSupplyStarInterpreter() {
        CronField cronField = new CronField(FieldType.HOUR, "*");

        assert InterpreterFactory.getInterpreter(cronField).getClass().equals(StarInterpreter.class);
    }

    @Test
    public void shouldSupplyStarSlashInterpreter() {
        CronField cronField = new CronField(FieldType.HOUR, "*/4");

        assert InterpreterFactory.getInterpreter(cronField).getClass().equals(StarSlashInterpreter.class);
    }
}