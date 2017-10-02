package com.trustedshops.examples.javaDesignPatterns.command;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class CommandEdgeCasesTest {
    private CommandParser parser;
    private CommandExecutor executor;

    @Before
    public void init() {
        parser = new CommandParserImpl();
        executor = new CommandExecutorImpl();
    }

    @Test
    public void oneCommandDoUndo() {
        FileSystemOperationsMock fs = new FileSystemOperationsMock().file("README.md");

        assertEquals(Arrays.asList("README.md"), fs.getFiles());

        Command commandChain = parser.parse("copy README.md LICENSE.txt");
        executor.execute(fs, commandChain);

        assertEquals(Arrays.asList("LICENSE.txt", "README.md"), fs.getFiles());

        executor.undo(fs, commandChain);

        assertEquals(Arrays.asList("README.md"), fs.getFiles());
    }

    @Test(expected = IllegalArgumentException.class)
    public void noLines() {
        parser.parse();
    }


    @Test(expected = IllegalArgumentException.class)
    public void commandNotFound() {
        parser.parse("xxx 1 2");
    }

    @Test(expected = IllegalArgumentException.class)
    public void noCommand() {
        parser.parse("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void noInvalidCommand() {
        parser.parse("copy");
    }

    @Test(expected = IllegalArgumentException.class)
    public void noInvalidCommandChain() {
        parser.parse("newClone 1.txt 2.txt", "");
    }

}
