package com.trustedshops.examples.javaDesignPatterns.chain;

import com.trustedshops.examples.javaDesignPatterns.utils.io.IOFile;
import com.trustedshops.examples.javaDesignPatterns.utils.statistics.MeasureGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DuplicateSearchElement extends AbstractIOFileChainElement {
    private final Map<String, Collection<IOFile>> database = new HashMap<>();
    @Override
    protected boolean doExecute(IOFile file) {
        String key = String.format("%s#%s", file.getName(), file.getSize());
        addToDatabase(key, file);
        return true;
    }

    private void addToDatabase(String key, IOFile file) {
        Collection<IOFile> entry = database.getOrDefault(key, new ArrayList<>());
        entry.add(file);
        database.put(key, entry);
    }

    public Collection<IOFile> getDuplicates() {
        Collection<IOFile> result = new ArrayList<>();
        for (Map.Entry<String, Collection<IOFile>> entry: database.entrySet()) {
            if (entry.getValue().size() > 1){
                result.addAll(entry.getValue());
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "DuplicateSearchElement{" +
                "database=" + getDuplicates() +
                '}';
    }
}
