package com.trustedshops.examples.javaDesignPatterns.chain;

import com.trustedshops.examples.javaDesignPatterns.utils.statistics.MeasureCount;
import com.trustedshops.examples.javaDesignPatterns.utils.statistics.MeasureGroup;
import com.trustedshops.examples.javaDesignPatterns.utils.io.IOFile;
import org.junit.Test;

import java.util.Arrays;

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

    /*
       exercise 1: lets add some stuff here:
         * lets find duplicate files by name and size
         * lets add a file name filter which can be configured dynamically

       exercise 2: lets restructure the code
     */
    @Test
    public void chainTest() {
        // some statistic stuff ...
        MeasureCount totalCount = new MeasureCount();
        MeasureCount totalSize = new MeasureCount();
        MeasureGroup extensions = new MeasureGroup();

        for(IOFile file: FILES) {
            // some statistic stuff ...
            if(file.getExtension().length() > 0) {
                extensions.add(file.getExtension());
            }
            totalCount.increase();
            totalSize.increaseWith(file.getSize());
            // ...
        }

        assertEquals(Arrays.asList("c", "exe", "txt"), extensions.getKeys());
        assertEquals(6, extensions.getCount("txt"));
    }

}
