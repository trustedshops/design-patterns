package com.trustedshops.examples.patterns.chain.filechain;

import com.trustedshops.examples.patterns.utils.io.IOFile;

public class PrintElement extends AbstractIOFileChainElement {
    @Override
    protected boolean doExecute(IOFile item) {
        System.out.println(item.getPath());
        return true;
    }
}
