package com.trustedshops.examples.javaDesignPatterns.chain.filechain;

import com.trustedshops.examples.javaDesignPatterns.utils.io.IOFile;

public class PrintElement extends AbstractIOFileChainElement {
    @Override
    protected boolean doExecute(IOFile item) {
        System.out.println(item.getPath());
        return true;
    }
}
