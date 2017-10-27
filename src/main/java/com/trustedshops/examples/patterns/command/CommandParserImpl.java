package com.trustedshops.examples.patterns.command;

import com.trustedshops.examples.patterns.command.commands.Command;
import com.trustedshops.examples.patterns.command.commands.CommandChain;
import com.trustedshops.examples.patterns.command.commands.MoveCommand;
import com.trustedshops.examples.patterns.command.commands.CopyCommand;
import com.trustedshops.examples.patterns.command.model.CommandOptions;

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
    public CommandChain parse(String... lines) {
        Objects.requireNonNull(lines);
        if(lines.length < 1) {
            throw new IllegalArgumentException("no commands found!");
        }
        Command first = parseCommandLine(lines[0]);
        Command last = first;
        for (String line: Arrays.copyOfRange(lines, 1, lines.length)) {
            Command newLast = parseCommandLine(line);
            last.setSuccessor(newLast);
            last = newLast;
        }
        return new CommandChain(first, last);
    }
}
