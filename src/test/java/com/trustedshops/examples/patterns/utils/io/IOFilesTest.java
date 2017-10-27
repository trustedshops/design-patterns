package com.trustedshops.examples.patterns.utils.io;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IOFilesTest {
    @Test
    public void getExtensionForNull() {
        assertThrows(NullPointerException.class, () -> IOFiles.getExtension((String) null));
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
