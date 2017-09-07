package com.trustedshops.examples.javaDesignPatterns.chain;

import com.trustedshops.examples.javaDesignPatterns.utils.io.IOFile;
import com.trustedshops.examples.javaDesignPatterns.utils.statistics.MeasureGroup;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;

public class DuplicateFileSearchElement extends IOFileChainElement {
    private final MeasureGroup duplicate = new MeasureGroup();
    @Override
    protected boolean doExecute(IOFile file) {
        duplicate.add(file.getName()+file.getSize());
        return true;
    }

    public Collection<String> getDuplicates() {
        Collection<String> result = new ArrayList<>();
        for (String key : duplicate.getKeys()) {
            Long current = duplicate.getCount(key);
            if (current > 1){
                result.add(key);
            }
        }
        return result;
    }
}
