package com.trustedshops.examples.javaDesignPatterns.chain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IOFilesTest {
    @Test(expected = NullPointerException.class)
    public void getExtensionForNull() {
        IOFiles.getExtension((String) null);
    }

    @Test
    public void getExtensionForBlank() {
        assertEquals("", IOFiles.getExtension(""));
    }

    @Test
    public void getExtensionForNoDotFound() {
        assertEquals("", IOFiles.getExtension("hello"));
    }

    @Test
    public void getExtensionForFileWithExtension() {
        assertEquals("txt", IOFiles.getExtension("hello.txt"));
    }

    @Test
    public void getExtensionForDotFile() {
        assertEquals("", IOFiles.getExtension(".hello"));
        assertEquals("", IOFiles.getExtension("/tmp/.hello"));
    }

    @Test
    public void getExtensionForDotFileWithExtension() {
        assertEquals("txt", IOFiles.getExtension(".hello.txt"));
    }
}
