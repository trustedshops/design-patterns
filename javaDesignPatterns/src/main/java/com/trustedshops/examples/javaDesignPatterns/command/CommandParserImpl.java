package com.trustedshops.examples.javaDesignPatterns.command;

import com.trustedshops.examples.javaDesignPatterns.command.commands.MoveCommand;
import com.trustedshops.examples.javaDesignPatterns.command.commands.CopyCommand;
import com.trustedshops.examples.javaDesignPatterns.command.model.CommandOptions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

public class CommandParserImpl implements CommandParser {

    private static final Map<String, Function<CommandOptions, Command>> COMMANDS = new HashMap<>();
    static {
        COMMANDS.put("copy", CopyCommand::new);
        COMMANDS.put("move", MoveCommand::new);
    }

    private Command parseCommandLine(String commandLine) {
        Objects.requireNonNull(commandLine);
        String[] args = commandLine.split("\\s");
        if(args.length != 3) {
            throw new IllegalArgumentException(String.format("not enough arguments (%d) in '%s'! usage: command src trg", args.length, commandLine));
        }
        String name = args[0];
        String src = args[1];
        String trg = args[2];
        if(!COMMANDS.containsKey(name)) {
            throw new IllegalArgumentException(String.format("command not found: %s", name));
        }
        return COMMANDS.get(name).apply(new CommandOptions(src, trg));

    }


    @Override
    public Command parse(String... lines) {
        Objects.requireNonNull(lines);
        if(lines.length < 1) {
            throw new IllegalArgumentException("no commads found!");
        }
        Command root = parseCommandLine(lines[0]);
        Command last = root;
        for (String line: Arrays.copyOfRange(lines, 1, lines.length)) {
            Command newLast = parseCommandLine(line);
            last.setSuccessor(newLast);
            last = newLast;
        }
        return root;
    }
}
