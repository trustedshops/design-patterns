package com.trustedshops.examples.javaDesignPatterns.chain;

import com.trustedshops.examples.javaDesignPatterns.utils.io.IOFile;
import com.trustedshops.examples.javaDesignPatterns.utils.statistics.MeasureCount;
import com.trustedshops.examples.javaDesignPatterns.utils.statistics.MeasureGroup;

public class StatisticFileElement extends IOFileChainElement {
    private final MeasureCount totalCount = new MeasureCount();
    private final MeasureCount totalSize = new MeasureCount();
    private final MeasureGroup extensions = new MeasureGroup();

    @Override
    protected boolean doExecute(IOFile file) {
        if(file.getExtension().length() > 0) {
            extensions.add(file.getExtension());
        }
        totalCount.increase();
        totalSize.increaseWith(file.getSize());
        return true;
    }

    public MeasureCount getTotalCount() {
        return totalCount;
    }

    public MeasureCount getTotalSize() {
        return totalSize;
    }

    public MeasureGroup getExtensions() {
        return extensions;
    }
}
