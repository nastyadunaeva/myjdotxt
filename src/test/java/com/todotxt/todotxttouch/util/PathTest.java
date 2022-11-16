package com.todotxt.todotxttouch.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PathTest {

    @Test
    public void testFileNameBlank() {
        String path = "";

        String returned = Path.fileName(path);

        assertEquals("", returned);
    }

    @Test
    public void testFileName() {
        String path = "test1/test2";

        String returned = Path.fileName(path);

        assertEquals("test2", returned);
    }

    @Test
    public void testFileNameWithSlash() {
        String path = "test1/test2/";

        String returned = Path.fileName(path);

        assertEquals("test2", returned);
    }
}
