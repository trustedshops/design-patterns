package com.trustedshops.examples.javaDesignPatterns.chain;

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
        FilterElement filterElement = new FilterElement("test");
        StatisticFileElement statisticFileElement = new StatisticFileElement();
        DuplicateFileSearchElement duplicateFileSearchElement = new DuplicateFileSearchElement();
        PrintElement printer = new PrintElement();

        filterElement.setSucessor(statisticFileElement);
        statisticFileElement.setSucessor(duplicateFileSearchElement);
        duplicateFileSearchElement.setSucessor(printer);


        IOFileChainElement root = statisticFileElement;

        for(IOFile file: FILES) {
            root.execute(file);
        }
        // ???
        assertEquals(Arrays.asList("test.txt705"), duplicateFileSearchElement.getDuplicates());
        assertEquals(Arrays.asList("c", "exe", "txt"), statisticFileElement.getExtensions().getKeys());
        assertEquals(6, statisticFileElement.getExtensions().getCount("txt"));
    }

}
