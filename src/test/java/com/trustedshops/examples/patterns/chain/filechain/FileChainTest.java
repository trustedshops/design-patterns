package com.trustedshops.examples.patterns.chain.filechain;

import com.trustedshops.examples.patterns.utils.io.IOFile;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static com.trustedshops.examples.patterns.MockUtils.*;
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
        ioFile("/tmp/x/XXX.md", 145L),
    };

    @Test
    public void chainTest() {
        FilterElement filterElement = new FilterElement(".exe");
        StatisticElement statisticFileElement = new StatisticElement();
        DuplicateSearchElement duplicateFileSearchElement = new DuplicateSearchElement();
        PrintElement printer = new PrintElement();

        filterElement.setSucessor(statisticFileElement);
        statisticFileElement.setSucessor(duplicateFileSearchElement);
        duplicateFileSearchElement.setSucessor(printer);

        AbstractIOFileChainElement root = filterElement;

        for(IOFile file: FILES) {
            root.execute(file);
        }

        assertEquals(Arrays.asList("/tmp/test.txt", "/tmp/B/test.txt", "/tmp/B/C/X/test.txt"),
                duplicateFileSearchElement.getDuplicates().stream().map(IOFile::getPath).collect(Collectors.toList()));
        assertEquals(Arrays.asList("c", "md", "txt"), statisticFileElement.getExtensions().getKeys());
        assertEquals(6, statisticFileElement.getExtensions().getCount("txt"));
    }

}
