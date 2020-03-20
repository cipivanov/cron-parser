package com.cron.parser;

import com.cron.parser.cli.CommandLineInterface;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CliTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(System.out);
        System.setErr(System.err);
    }

    @Test
    public void shouldOutputAValidInterpretationToTheConsole() {
        String expectedOutput =
                "minute        0 15 30 45\n" +
                        "hour          0\n" +
                        "day of month  1 15\n" +
                        "month         1 2 3 4 5 6 7 8 9 10 11 12\n" +
                        "day of week   1 2 3 4 5\n" +
                        "command       /usr/bin/find\n";

        CommandLineInterface.main(new String[]{"*/15 0 1,15 * 1-5 /usr/bin/find"});
        assert expectedOutput.equals(outContent.toString());
    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldThrowAnIllegalArgumentException() {
        CommandLineInterface.main(new String[]{"*/15 0 1,15 * 1-5", "/usr/bin/find"});
    }
}