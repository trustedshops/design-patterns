package com.trustedshops.examples.javaDesignPatterns.chain;

import com.trustedshops.examples.javaDesignPatterns.chain.statistics.MeasureCount;
import com.trustedshops.examples.javaDesignPatterns.chain.statistics.MeasureGroup;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

import static com.trustedshops.examples.javaDesignPatterns.MockUtils.*;
import static org.junit.Assert.assertEquals;

public class FileChainTest {
    private static final IOFile[] FILES = new IOFile[] {
        ioFile("/tmp/test.txt", 705L),
        ioFile("/tmp/A/bla.exe", 687805L),
        ioFile("/tmp/B/test.txt", 5L),
        ioFile("/tmp/foo.txt", 54505L),
        ioFile("/tmp/hello", 705L),
        ioFile("/tmp/B/test.txt", 705L),
        ioFile("/tmp/B/C/X/test.txt", 705L),
        ioFile("/tmp/XXX.txt", 70L),
        ioFile("/tmp/foo.c", 70L),
        ioFile("/tmp/Makefile", 70L),
        ioFile("/tmp/x/.system", 145L),
    };

    @Test
    public void chainTest() {
        MeasureCount totalCount = new MeasureCount();
        MeasureCount totalSize = new MeasureCount();
        MeasureGroup extensions = new MeasureGroup();

        for(IOFile file: FILES) {
            if(file.getExtension().length() > 0) {
                extensions.add(file.getExtension());
            }
            totalCount.increase();
            totalSize.increaseWith(file.getSize());
        }

        assertEquals(Arrays.asList("c", "exe", "txt"), extensions.getKeys());
        assertEquals(6, extensions.getCount("txt"));
    }

}
