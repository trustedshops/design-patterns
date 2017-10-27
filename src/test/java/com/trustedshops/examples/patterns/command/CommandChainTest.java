package com.trustedshops.examples.patterns.command;

import com.trustedshops.examples.patterns.command.commands.CommandChain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandChainTest {
    private CommandParser parser;

    @BeforeEach
    public void init() {
        parser = new CommandParserImpl();
    }

    @Test
    public void doUndo() {
        FileSystemOperationsMock fs = new FileSystemOperationsMock()
                .file("README.md")
                .file("Hello.java")
                .file("pom.xml")
                .file("HelloTest.java");

        /* initial setup */

        assertEquals(asList(
                "Hello.java",
                "HelloTest.java",
                "README.md",
                "pom.xml"), fs.getFiles());

        CommandChain commandChain = parser.parse(
                "move Hello.java src/main/java/Hello.java",
                "move HelloTest.java src/test/java/HelloTest.java",
                "copy README.md LICENSE.txt",
                "move LICENSE.txt LICENSE");

        commandChain.execute(fs);

        /* commands executed */

        assertEquals(asList(
                "LICENSE",
                "README.md",
                "pom.xml",
                "src/main/java/Hello.java",
                "src/test/java/HelloTest.java"), fs.getFiles());

        commandChain.undo(fs);

        /* after undo operation */

        assertEquals(asList(
                "Hello.java",
                "HelloTest.java",
                "README.md",
                "pom.xml"), fs.getFiles());
    }
}
