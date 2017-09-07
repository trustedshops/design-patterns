package com.trustedshops.examples.javaDesignPatterns.chain;

import com.trustedshops.examples.javaDesignPatterns.utils.io.IOFile;

public class PrintElement extends IOFileChainElement {
    @Override
    protected boolean doExecute(IOFile item) {
        System.out.println(item.getPath());
        return true;
    }
}
