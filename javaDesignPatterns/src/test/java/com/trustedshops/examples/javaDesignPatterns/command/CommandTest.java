package com.trustedshops.examples.javaDesignPatterns.command;

import com.trustedshops.examples.javaDesignPatterns.command.io.FileSystemOperations;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class CommandTest {
    private CommandParser parser;
    private CommandExecutor executor;

    @Before
    public void init() {
        parser = new CommandParserImpl();
        executor = new CommandExecutorImpl();
    }

    @Test
    public void doUndo() {
        FileSystemOperationsMock fs = new FileSystemOperationsMock()
                .file("README.md")
                .file("Hello.java")
                .file("pom.xml")
                .file("HelloTest.java");

        /* initial setup */

        assertEquals(Arrays.asList(
                "Hello.java",
                "HelloTest.java",
                "README.md",
                "pom.xml"), fs.getFiles());

        Command commandChain = parser.parse(
                "move Hello.java src/main/java/Hello.java",
                "move HelloTest.java src/test/java/HelloTest.java",
                "copy README.md LICENSE.txt");

        executor.execute(fs, commandChain);

        /* commands executed */

        assertEquals(Arrays.asList(
                "LICENSE.txt",
                "README.md",
                "pom.xml",
                "src/main/java/Hello.java",
                "src/test/java/HelloTest.java"), fs.getFiles());

        executor.undo(fs, commandChain);

        /* after undo operation */

        assertEquals(Arrays.asList(
                "Hello.java",
                "HelloTest.java",
                "README.md",
                "pom.xml"), fs.getFiles());
    }
}
