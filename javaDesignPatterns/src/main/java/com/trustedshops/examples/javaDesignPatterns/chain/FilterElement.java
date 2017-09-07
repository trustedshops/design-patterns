package com.trustedshops.examples.javaDesignPatterns.chain;

import com.trustedshops.examples.javaDesignPatterns.utils.io.IOFile;

public class FilterElement extends AbstractIOFileChainElement {
    private final String value;

    public FilterElement(String value) {
        this.value = value;
    }

    @Override
    protected boolean doExecute(IOFile item) {
       if(item.getName().contains(value)) {
           return false;
       }
       return true;
    }
}
