package com.trustedshops.examples.patterns.command;

import com.trustedshops.examples.patterns.command.commands.CommandChain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CommandEdgeCasesTest {
    private CommandParser parser;

    @BeforeEach
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

    @Test
    public void noLines() {
        assertThrows(IllegalArgumentException.class, () -> parser.parse());
    }


    @Test
    public void commandNotFound() {
        assertThrows(IllegalArgumentException.class, () -> parser.parse("xxx 1 2"));
    }

    @Test
    public void noCommand() {
        assertThrows(IllegalArgumentException.class, () -> parser.parse(""));
    }

    @Test
    public void noInvalidCommand() {
        assertThrows(IllegalArgumentException.class, () -> parser.parse("copy"));
    }

    @Test
    public void noInvalidCommandChain() {
        assertThrows(IllegalArgumentException.class, () -> parser.parse("newClone 1.txt 2.txt", ""));
    }

}
