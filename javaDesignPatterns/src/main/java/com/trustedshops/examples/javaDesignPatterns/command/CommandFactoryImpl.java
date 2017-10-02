package com.trustedshops.examples.javaDesignPatterns.command;

import com.trustedshops.examples.javaDesignPatterns.command.commands.MoveCommand;
import com.trustedshops.examples.javaDesignPatterns.command.commands.CopyCommand;
import com.trustedshops.examples.javaDesignPatterns.command.model.CommandOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

public class CommandFactoryImpl implements CommandFactory {

    private static final Map<String, Function<CommandOptions, Command>> COMMANDS = new HashMap<>();
    static {
        COMMANDS.put("copy", CopyCommand::new);
        COMMANDS.put("move", MoveCommand::new);
    }

    @Override
    public Command create(String commandLine) {
        Objects.requireNonNull(commandLine);
        String[] args = commandLine.split("\\\\s");
        if(args.length != 3) {
            throw new IllegalArgumentException("not enough arguments! usage: command src trg");
        }
        String name = args[0];
        String src = args[1];
        String trg = args[2];
        if(!COMMANDS.containsKey(name)) {
            throw new IllegalArgumentException(String.format("no command for: %s", name));
        }
        return COMMANDS.get(name).apply(new CommandOptions(src, trg));

    }
}
