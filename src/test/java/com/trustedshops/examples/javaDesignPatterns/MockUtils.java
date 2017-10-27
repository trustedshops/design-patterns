package com.trustedshops.examples.javaDesignPatterns;

import com.trustedshops.examples.javaDesignPatterns.utils.io.IOFile;
import com.trustedshops.examples.javaDesignPatterns.utils.io.IOFiles;

import java.nio.file.FileSystems;
import java.nio.file.Path;

import static org.mockito.Mockito.*;

public final class MockUtils {
    private MockUtils() {
    }

    public static IOFile ioFile(String path, long size) {
        IOFile file = mock(IOFile.class);
        Path nioPath = FileSystems.getDefault().getPath(path);
        when(file.getPath()).thenReturn(nioPath.toString());
        when(file.getName()).thenReturn(nioPath.getFileName().toString());
        when(file.getExtension()).thenReturn(IOFiles.getExtension(path));
        when(file.getSize()).thenReturn(size);
        return file;
    }
}
