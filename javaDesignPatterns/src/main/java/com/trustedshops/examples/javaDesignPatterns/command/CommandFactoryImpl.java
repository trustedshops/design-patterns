package com.trustedshops.examples.javaDesignPatterns.command;

import com.trustedshops.examples.javaDesignPatterns.command.commands.BoldCommand;
import com.trustedshops.examples.javaDesignPatterns.command.commands.DeleteCommand;
import com.trustedshops.examples.javaDesignPatterns.command.commands.TypeCommand;

import java.util.HashMap;
import java.util.Map;

public class CommandFactoryImpl implements CommandFactory {
    private static final Map<String, Class<? extends Command>> COMMANDS = new HashMap<>();
    static {
        COMMANDS.put("delete", DeleteCommand.class);
        COMMANDS.put("type", TypeCommand.class);
        COMMANDS.put("bold", BoldCommand.class);
    }

    @Override
    public Command create(String name) throws CommandNotFoundException {
        try {
            if(!COMMANDS.containsKey(name)) {
                throw new CommandNotFoundException(String.format("no command for: %s", name));
            }
            return COMMANDS.get(name).newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
