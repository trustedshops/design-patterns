package com.trustedshops.examples.javaDesignPatterns.command;

import com.trustedshops.examples.javaDesignPatterns.command.model.Document;
import com.trustedshops.examples.javaDesignPatterns.command.model.SelectedArea;

public interface Command {
    void execute(SelectedArea position, Document document);
}
