package com.trustedshops.examples.javaDesignPatterns.command;

import com.trustedshops.examples.javaDesignPatterns.command.commands.CommandChain;
import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.*;

import static org.junit.Assert.assertEquals;

public class CommandEdgeCasesTest {
    private CommandParser parser;

    @Before
    public void init() {
        parser = new CommandParserImpl();
    }

    @Test
    public void oneCommandDoUndo() {
        FileSystemOperationsMock fs = new FileSystemOperationsMock().file("README.md");

        assertEquals(asList("README.md"), fs.getFiles());

        CommandChain commandChain = parser.parse("copy README.md LICENSE.txt");
        commandChain.execute(fs);

        assertEquals(asList("LICENSE.txt", "README.md"), fs.getFiles());

        commandChain.undo(fs);

        assertEquals(asList("README.md"), fs.getFiles());
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
