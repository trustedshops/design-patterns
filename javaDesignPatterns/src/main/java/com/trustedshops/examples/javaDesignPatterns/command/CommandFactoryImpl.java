package com.trustedshops.examples.javaDesignPatterns.command;

import java.util.HashMap;
import java.util.Map;

public class CommandFactoryImpl implements CommandFactory {
    private static final Map<String, Class<? extends Command>> COMMANDS = new HashMap<>();
    static {
        COMMANDS.put("listFiles", ListFilesCommand.class);
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
