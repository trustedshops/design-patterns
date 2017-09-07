package com.trustedshops.examples.javaDesignPatterns.command;

import com.trustedshops.examples.javaDesignPatterns.chain.*;
import com.trustedshops.examples.javaDesignPatterns.utils.io.Directorys;
import com.trustedshops.examples.javaDesignPatterns.utils.io.IOFile;
import com.trustedshops.examples.javaDesignPatterns.utils.io.IOFileFactory;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class DirStatCommand implements Command {

    @Override
    public void execute(List<String> commandArgs, Map<String, Collection<String>> commandOptions) {
        if(commandArgs.size() == 0) {
            throw new IllegalArgumentException("path argument is missing!");
        }

        StatisticElement statisticFileElement = new StatisticElement();
        DuplicateSearchElement duplicateFileSearchElement = new DuplicateSearchElement();

        statisticFileElement.setSucessor(duplicateFileSearchElement);

        AbstractIOFileChainElement root = statisticFileElement;

        traverse(commandArgs.get(0), root::execute);

        System.out.println(statisticFileElement.toString());
        System.out.println("duplicates found: " + duplicateFileSearchElement.getDuplicates().size());
    }

    private void traverse(String root, Consumer<IOFile> fileConsumer) {
        Directorys.traverse(root, (p) -> fileConsumer.accept(IOFileFactory.getFile(p)));
    }
}
